package co.edu.uniquindio.clienteServidor.infraLab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 12345);
    System.out.println("Conectado al servidor.");

    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    out.println("Hola, soy Dillan");

    String response = in.readLine();
    System.out.println("Respuesta del servidor: " + response);

    socket.close();
}
}