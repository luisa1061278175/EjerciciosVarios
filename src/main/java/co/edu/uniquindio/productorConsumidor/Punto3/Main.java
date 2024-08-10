package co.edu.uniquindio.productorConsumidor.Punto3;

public class Main {

    static char[] arreglo = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        P1 p1 = new P1(arreglo, buffer);
        P2 p2 = new P2(arreglo, buffer);
        P3 p3 = new P3(arreglo, buffer);

        Consumidor consumidor = new Consumidor(buffer);
        p1.start();
        p2.start();
        p3.start();
        consumidor.start();
    }

}