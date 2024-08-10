package co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4.controller;

import co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4.config.RabbitFactory;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import static co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4.util.Constantes.QUEUE_NUEVA_PUBLICACION;

public class ModelFactoryController implements Runnable {

    private RabbitFactory rabbitFactory;
    private ConnectionFactory connectionFactory;
    private Thread hiloServicioConsumer1;

    private static final String QUEUE_REQUEST = "operaciones_cliente";
    private static final String QUEUE_RESPONSE = "resultados_servidor";

    public ModelFactoryController(String servidorIP, int puerto) {
        initRabbitConnection(servidorIP, puerto);
    }

    private void initRabbitConnection(String servidorIP, int puerto) {
        rabbitFactory = new RabbitFactory(servidorIP, puerto);
        connectionFactory = rabbitFactory.getConnectionFactory();
        System.out.println("Conexión establecida con el servidor: " + servidorIP + ":" + puerto);
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NUEVA_PUBLICACION, false, false, false, null);
            channel.queueDeclare(QUEUE_RESPONSE, false, false, false, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consumirMensajesServicio1() {
        hiloServicioConsumer1 = new Thread(this);
        hiloServicioConsumer1.start();
    }

    @Override
    public void run() {
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicConsume(QUEUE_REQUEST, true, (consumerTag, delivery) -> {
                String message = new String(delivery.getBody());
                System.out.println("Operación recibida del cliente: " + message);
                String resultado = procesarOperacion(message);
                enviarResultado(resultado);
            }, consumerTag -> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String procesarOperacion(String mensaje) {
        String[] parametros = mensaje.split(",");
        if (parametros.length != 2) {
            return "Error: Se esperaban 2 parámetros separados por coma.";
        }
        String operacion = parametros[0];
        String argumento = parametros[1];
        switch (operacion) {
            case "1":
                return "Cantidad de dígitos de " + argumento + ": " + contarDigitosRecursivo(Integer.parseInt(argumento));
            case "2":
                int[] resultado = contarVocalesConsonantesRecursivo(argumento.toLowerCase(), 0, 0, 0);
                return "Vocales y consonantes de '" + argumento + "': " + resultado[0] + " vocales, " + resultado[1] + " consonantes";
            default:
                return "Error: Operación no válida.";
        }
    }

    private int contarDigitosRecursivo(int numero) {
        if (numero < 10) {
            return 1;
        }
        return 1 + contarDigitosRecursivo(numero / 10);
    }

    private int[] contarVocalesConsonantesRecursivo(String cadena, int index, int vocales, int consonantes) {
        if (index == cadena.length()) {
            return new int[]{vocales, consonantes};
        }
        char c = cadena.charAt(index);
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            } else {
                consonantes++;
            }
        }
        return contarVocalesConsonantesRecursivo(cadena, index + 1, vocales, consonantes);
    }

    private void enviarResultado(String resultado) {
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.basicPublish("", QUEUE_RESPONSE, null, resultado.getBytes());
            System.out.println("Resultado enviado al cliente: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
