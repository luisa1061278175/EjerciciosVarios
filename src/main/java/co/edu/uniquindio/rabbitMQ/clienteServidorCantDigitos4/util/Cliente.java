package co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4.util;

import com.rabbitmq.client.*;

import java.util.Scanner;

public class Cliente {
    private static final String QUEUE_REQUEST = "operaciones_cliente";
    private static final String QUEUE_RESPONSE = "resultados_servidor";

    public static void main(String[] args) {
        String servidorIP = "localhost";
        int puerto = 5672;

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(servidorIP);
            factory.setPort(puerto);
            factory.setUsername("guest");
            factory.setPassword("guest");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

//se utiliza para manejar las colas
            channel.queueDeclare(QUEUE_REQUEST, false, false, false, null);
            channel.queueDeclare(QUEUE_RESPONSE, false, false, false, null);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el tipo de operación (1 para contar dígitos, 2 para contar vocales y consonantes): ");
            String operacion = scanner.nextLine();
            System.out.println("Ingrese el argumento para la operación: ");
            String argumento = scanner.nextLine();
            String mensaje = operacion + "," + argumento;

            channel.basicPublish("", QUEUE_REQUEST, null, mensaje.getBytes());
            System.out.println("Mensaje enviado al servidor: " + mensaje);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("Resultado recibido del servidor: " + message);
            };
            channel.basicConsume(QUEUE_RESPONSE, true, deliverCallback, consumerTag -> {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
