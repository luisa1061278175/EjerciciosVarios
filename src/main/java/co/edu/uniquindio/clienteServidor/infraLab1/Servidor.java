package co.edu.uniquindio.clienteServidor.infraLab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor esperando conexión...");
        Socket socket = serverSocket.accept();
        System.out.println("Cliente conectado.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = in.readLine();
        System.out.println("Mensaje recibido del cliente: " + message);

        out.println("Mensaje recibido: " + message);

        socket.close();
        serverSocket.close();
    }
}
