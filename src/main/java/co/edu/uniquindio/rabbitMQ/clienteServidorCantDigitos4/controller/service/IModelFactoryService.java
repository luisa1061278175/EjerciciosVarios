package co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4.controller.service;

public interface IModelFactoryService {
    void producirMensaje(String queue, String message);
}
