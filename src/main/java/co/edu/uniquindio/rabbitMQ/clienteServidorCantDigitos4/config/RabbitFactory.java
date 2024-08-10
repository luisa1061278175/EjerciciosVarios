package co.edu.uniquindio.rabbitMQ.clienteServidorCantDigitos4.config;

import com.rabbitmq.client.ConnectionFactory;

public class RabbitFactory {
    private ConnectionFactory connectionFactory;

    public RabbitFactory(String host, int port) {
        this.connectionFactory = new ConnectionFactory();
        this.connectionFactory.setHost(host);
        this.connectionFactory.setPort(port);
        this.connectionFactory.setUsername("guest");
        this.connectionFactory.setPassword("guest");
    }

    public RabbitFactory() {

    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }
}
