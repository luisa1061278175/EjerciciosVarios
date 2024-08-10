package co.edu.uniquindio.productorConsumidor.Punto3;

public class P1 extends Thread {

    // P1 lanza solo vocales y debe esperar 500 milisegundos para enviar la siguiente vocal
    private char[] lista;
    private Buffer buffer;

    public P1(char[] lista, Buffer buffer) {
        this.lista = lista;
        this.buffer = buffer;
    }

    // Método para verificar si el arreglo contiene solo vocales
    public boolean contieneSoloVocales(char[] lista) {
        for (char c : lista) {
            if (!esVocal(c)) {
                return false;
            }
        }
        return true;
    }

    // Método para verificar si un carácter es una vocal
    private boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    @Override
    public void run() {
        for (char c : lista) {
            if (esVocal(c)) { // Verificar si el carácter actual es una vocal
                System.out.println("Hilo 1 crea la vocal: " + c);
                buffer.lanzar(c);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}