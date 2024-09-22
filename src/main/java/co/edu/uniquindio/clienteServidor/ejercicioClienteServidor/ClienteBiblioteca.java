package co.edu.uniquindio.clienteServidor.ejercicioClienteServidor;

import java.io.*;
import java.net.*;

public class ClienteBiblioteca {
    public static void main(String[] args) {
        try (Socket socket = new Socket("445ea1cf4e9f7290684a1afa227bd59b.serveo.net", 38009);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String serverResponse;
            boolean done = false;

            while (!done) {
                // Leer y mostrar la lista de libros del servidor
                while ((serverResponse = in.readLine()) != null) {
                    System.out.println(serverResponse);
                    if (serverResponse.startsWith("Lista de libros:")) {
                        break; // Sale del bucle cuando muestra la lista de libros
                    }
                }

                // Ingresar el número del libro a reservar
                System.out.print("Elige el número del libro a reservar: ");
                String userInput = stdIn.readLine();
                out.println(userInput);

                // Leer y mostrar la respuesta del servidor
                String serverReply = in.readLine();
                System.out.println(serverReply);

                // Verifica si se ha reservado el libro y termina el bucle
                if (serverReply.startsWith("Reservaste") || serverReply.startsWith("Libro no disponible")) {
                    done = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
