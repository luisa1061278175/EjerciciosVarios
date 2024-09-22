package co.edu.uniquindio.estructuraDeDatos.listasEnlazadas.listaDoblementeEnlazada;


// Clase ListaDoblementeEnlazada
public class ListaDoblementeEnlazada {
    private Nodo cabeza;
    private Nodo cola;

    // Método agregar
    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Método eliminar
    public void eliminar(int valor) {
        if (cabeza == null) return;
        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.valor == valor) {
                actual.siguiente = actual.siguiente.siguiente;
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual;
                } else {
                    cola = actual;
                }
                return;
            }
            actual = actual.siguiente;
        }
    }

    // Método buscar
    public boolean buscar(int valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.valor == valor) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // Método imprimir
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método imprimir inverso
    public void imprimirInverso() {
        Nodo actual = cola;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    // Método insertar al inicio
    public void insertarAlInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    // Método insertar al final
    public void insertarAlFinal(int valor) {
        agregar(valor);
    }

    // Método obtener tamaño
    public int obtenerTamano() {
        int tamano = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            tamano++;
            actual = actual.siguiente;
        }
        return tamano;
    }

    // Método es vacía
    public boolean esVacia() {
        return cabeza == null;
    }

    // Método obtener primer nodo
    public Nodo getPrimero() {
        return cabeza;
    }

    // Método obtener último nodo
    public Nodo getUltimo() {
        return cola;
    }

    // Método obtener siguiente nodo
    public Nodo getNext(Nodo nodo) {
        return nodo.siguiente;
    }

    // Método obtener nodo anterior
    public Nodo getAnterior(Nodo nodo) {
        return nodo.anterior;
    }

    // Método modificar
    public void modificar(int valor, int nuevoValor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.valor == valor) {
                actual.valor = nuevoValor;
                return;
            }
            actual = actual.siguiente;
        }
    }
}




