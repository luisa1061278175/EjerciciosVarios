package co.edu.uniquindio.clienteServidor.ClienteServidor2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 1234;  // Puerto del servidor
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);

            while (true) {
                // Acepta conexiones de clientes
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                // Lee el mensaje del cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                String mensaje = entrada.readLine();
                System.out.println("Mensaje recibido: " + mensaje);

                // Envía respuesta al cliente
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
                salida.println("Respuesta del servidor: " + mensaje);

                // Cierra la conexión con el cliente
                cliente.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
