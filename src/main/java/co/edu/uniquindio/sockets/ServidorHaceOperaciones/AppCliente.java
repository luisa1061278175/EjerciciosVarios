package co.edu.uniquindio.sockets.ServidorHaceOperaciones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class AppCliente {

    String host;
    int puerto;
    Socket socketComunicacion;
    ObjectInputStream flujoEntradaObjeto;

    public AppCliente(String host, int puerto) {
        this.puerto = puerto;
        this.host = host;
    }



    public void iniciarCliente() {


        try {
            crearConexion();

            flujoEntradaObjeto = new ObjectInputStream(socketComunicacion.getInputStream());

            recibirObjeto();

            flujoEntradaObjeto.close();
            socketComunicacion.close();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    private void recibirObjeto() throws ClassNotFoundException, IOException {

        Universidad universidad = (Universidad) flujoEntradaObjeto.readObject();

        for (Facultad facultad : universidad.getListaFacultades()) {
            System.out.println("Facultad: "+facultad.getNombre()+ " C�digo: "+facultad.getCodigo());
        }
    }

    private void crearConexion() throws IOException {
        // TODO Auto-generated method stub
        socketComunicacion = new Socket(host,puerto);

    }

}
