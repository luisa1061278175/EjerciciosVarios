package co.edu.uniquindio.funcionesVarias;

import java.util.Scanner;

public class InversorDePalabras {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la palabra: ");
        String  palabra = scanner.next();


        palabraInvertida(palabra);

    }

    public static void palabraInvertida(String palabraOriginal){
        String palabraI="";

        for (int i = palabraOriginal.length()-1; i >=0 ; i--) {
            palabraI= palabraI+palabraOriginal.charAt(i);

        }
        System.out.println("palabra invertida: " +palabraI);
    }
}
