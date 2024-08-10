package co.edu.uniquindio.productorConsumidor.Punto3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Consumidor extends Thread {
    private Buffer buffer;
    private static char[] arreglo = new char[14]; // Ajustado el tamaño del arreglo para contener la palabra completa
    private static char[] palabra = {'u', 'n', 'i', 'q', 'u', 'i', 'n', 'd', 'i', 'o', '2', '0', '2', '3'};
    private static ArrayList<Character> auxiliar = new ArrayList<>();

    public Consumidor(Buffer t) {
        buffer = t;
    }
//se debe corregir que consuma de a 2 caracteres

    public void run() {
        while (true) {
            for (int j = 0; j < 36; j++) {
                char c = buffer.recoger();
                isContenido(c);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            escribirLetrasSobrantes();
        }

    }

    public void isContenido(char c) {
        boolean contenido = false;
        for (int i = 0; i < palabra.length; i++) {
            if (c == palabra[i]) {
                arreglo[i] = c;
                contenido = true;

            }
        }
        if (!contenido) {
            auxiliar.add(c);
        }
        System.out.println("Arreglo con la palabra: " + String.valueOf(arreglo));
        System.out.println("Arreglo con caracteres sobrantes: " + auxiliar);

    }


    //para guardarlo en un txt
    public void escribirLetrasSobrantes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("letrasSobrantes.txt", true))) {
            for (char c : auxiliar) {
                writer.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
