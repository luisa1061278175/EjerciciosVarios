package co.edu.uniquindio.recursividad;

public class SumarArregloDivideYVenceras  {
    public static void main(String[] args) {
    int[] arreglo = {1, 1, 2, 3 ,2};
    System.out.println(sumarArreglo(arreglo));
}

public static int sumarArreglo(int[] arreglo) {
    return sumarArreglo(arreglo, 0, arreglo.length - 1);
}

// Método que divide el arreglo y suma las partes
private static int sumarArreglo(int[] arreglo, int inicio, int fin) {
    // Caso base: si hay un solo elemento, devolverlo
    if (inicio == fin) {
        return arreglo[inicio];
    }

    // Caso base: si no hay elementos
    if (inicio > fin) {
        return 0;
    }

    // Dividir el arreglo en dos mitades
    int medio = (inicio + fin) / 2;

    // Sumar la primera mitad y la segunda mitad
    int sumaIzquierda  = sumarArreglo(arreglo, inicio, medio);
    int sumaDerecha = sumarArreglo(arreglo, medio + 1, fin);

    // Combinar las sumas de ambas mitades
    return sumaIzquierda + sumaDerecha;
}
}