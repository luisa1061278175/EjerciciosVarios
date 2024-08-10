package co.edu.uniquindio.sockets.ServidorHaceOperaciones;

import co.edu.uniquindio.sockets.ejemploEnviaryRecibirObjetos.AppCliente;

public class MainCliente {

	public static void main(String[] args) {
		
		co.edu.uniquindio.sockets.ServidorHaceOperaciones.AppCliente appCliente = new co.edu.uniquindio.sockets.ServidorHaceOperaciones.AppCliente("localhost",8081);
		System.out.println("Iniciando cliente\n");
		appCliente.iniciarCliente();
	}

}
