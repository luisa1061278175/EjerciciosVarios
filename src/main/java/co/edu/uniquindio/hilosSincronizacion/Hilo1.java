package co.edu.uniquindio.hilosSincronizacion;

class Hilo1 extends Thread {
    private Object lock;

    public Hilo1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 3; i++) {
                    String variable = "hola" + "hola" + "hola";
                    System.out.println("Hilo 1: " + variable);
                    lock.notify();
                    lock.wait();
                }
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
