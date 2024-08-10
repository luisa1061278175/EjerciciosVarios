package co.edu.uniquindio.rabbitMQ.consumer.controller.service;

public interface IModelFactoryService {
    void producirMensaje(String queue, String message);
}
