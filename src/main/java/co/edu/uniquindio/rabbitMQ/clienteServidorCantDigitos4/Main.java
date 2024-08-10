package co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4;

import co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4.controller.ModelFactoryController;

public class Main {
    public static void main(String[] args) {
        String servidorIP = "localhost";
        int puerto = 5672;
        ModelFactoryController modelFactoryController = new ModelFactoryController(servidorIP, puerto);
        modelFactoryController.consumirMensajesServicio1();
    }
}
