package co.edu.uniquindio.hilosSincronizacion;


public class Main extends Thread {


    public static void main(String[] args) {
        Object lock = new Object();
        Hilo1 hilo1 = new Hilo1(lock);
        Hilo2 hilo2 = new Hilo2(lock);

        hilo1.start();
        hilo2.start();
    }
}