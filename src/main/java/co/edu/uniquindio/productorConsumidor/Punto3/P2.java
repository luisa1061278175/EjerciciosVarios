package co.edu.uniquindio.productorConsumidor.Punto3;


public class P2 extends Thread {

    // P2 lanza consonantes y debe esperar 1000 milisegundos para enviar la siguiente letra
    private char[] lista;
    private Buffer buffer;

    public P2(char[] lista, Buffer buffer) {
        this.lista = lista;
        this.buffer = buffer;
    }

    public static boolean esConsonante(char c) {
        c = Character.toLowerCase(c);
        return Character.isLetter(c) && !esVocal(c);
    }

    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    @Override
    public void run() {
        for (int i =0;i<lista.length;i++) {
            if (esConsonante(lista[i])) {
                System.out.println("Hilo 2 crea la consonante: " + lista[i]);
                buffer.lanzar(lista[i]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}