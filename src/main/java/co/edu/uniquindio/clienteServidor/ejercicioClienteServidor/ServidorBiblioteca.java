package co.edu.uniquindio.clienteServidor.ejercicioClienteServidor;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServidorBiblioteca {
    private static List<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        // Inicialización de la lista de libros
        libros.add(new Libro("El Quijote", "Miguel de Cervantes", true));
        libros.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", true));

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Servidor iniciado. Esperando clientes...");

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                new Thread(new ManejadorCliente(clienteSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ManejadorCliente implements Runnable {
        private Socket clienteSocket;

        public ManejadorCliente(Socket clienteSocket) {
            this.clienteSocket = clienteSocket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
            ) {
                // Enviar lista de libros al cliente
                out.println("Lista de libros:");
                for (int i = 0; i < libros.size(); i++) {
                    out.println(i + ": " + libros.get(i));
                }

                // Esperar una solicitud de reserva
                String input = in.readLine();
                int index = Integer.parseInt(input);

                if (index >= 0 && index < libros.size()) {
                    Libro libro = libros.get(index);
                    if (libro.disponible) {
                        libro.disponible = false; // Marcar el libro como no disponible
                        out.println("Reservaste el libro: " + libro.titulo);
                        System.out.println("El cliente reservó el libro: " + libro.titulo);
                    } else {
                        out.println("Libro no disponible.");
                    }
                } else {
                    out.println("Índice inválido.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
