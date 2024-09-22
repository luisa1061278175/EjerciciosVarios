package co.edu.uniquindio.estructuraDeDatos.listasEnlazadas.listaDoblementeEnlazada;

class Nodo {
    int valor;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }
}
