package co.edu.uniquindio.productorConsumidor.Punto3;

public class P3 extends Thread {

    // P3 lanza números de 1 a 9 y debe esperar 2000 milisegundos para enviar el siguiente número
    private char[] lista;
    private Buffer buffer;

    public P3(char[] lista, Buffer buffer) {
        this.lista = lista;
        this.buffer = buffer;
    }

    public static boolean esNumero(char c) {
        return Character.isDigit(c);
    }

    @Override
    public void run() {
        for (char c : lista) {
            if (esNumero(c)) {
                System.out.println("Hilo 3 crea el número: " + c);
                buffer.lanzar(c);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}