package co.edu.uniquindio.estructuraDeDatos.listasEnlazadas.listaCircularmenteSimpleEnlazada;

public class Main {
    public static void main(String[] args) {
        ListaCircularmenteSimpleEnlazada lista = new ListaCircularmenteSimpleEnlazada();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.imprimir(); // Imprime: 1 2 3
        lista.eliminar(2);
        lista.imprimir(); // Imprime: 1 3
        lista.insertarAlInicio(0);
        lista.imprimir(); // Imprime: 0 1 3
        System.out.println("Tamaño: " + lista.obtenerTamano()); // Imprime: Tamaño: 3
        System.out.println("Es vacía: " + lista.esVacia()); // Imprime: Es vacía: false
    }
}
