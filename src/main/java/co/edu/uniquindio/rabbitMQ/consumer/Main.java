package co.edu.uniquindio.rabbitMQ.consumer;

import co.edu.uniquindio.rabbitMQ.consumer.controller.ModelFactoryController;

import static co.edu.uniquindio.rabbitMQ.consumer.util.Constantes.QUEUE_NUEVA_PUBLICACION;

public class Main {
    public static void main(String[] args) {
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
        String mensaje = "";
        mensaje += "100;";
        mensaje += "LUISA";
        modelFactoryController.producirMensaje(QUEUE_NUEVA_PUBLICACION, mensaje);
    }
}
