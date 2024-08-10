package co.edu.uniquindio.hilosSincronizacion;

class Hilo2 extends Thread {
    private Object lock;

    public Hilo2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 3; i++) {
                    String var = "hola" + "hola" + "hola";
                    System.out.println("Hilo 2: " + var);
                    lock.notify();
                    if (i < 2) {
                        lock.wait();
                    }
                }
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}