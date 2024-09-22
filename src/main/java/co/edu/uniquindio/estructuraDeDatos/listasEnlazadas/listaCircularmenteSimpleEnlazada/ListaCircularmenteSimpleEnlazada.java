package co.edu.uniquindio.estructuraDeDatos.listasEnlazadas.listaCircularmenteSimpleEnlazada;


// Clase Nodo


// Clase ListaCircularmenteSimpleEnlazada
public class ListaCircularmenteSimpleEnlazada {
    private Nodo cabeza;

    // Método agregar
    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
    }

    // Método eliminar
    public void eliminar(int valor) {
        if (cabeza == null) return;
        if (cabeza.valor == valor) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != cabeza) {
                    actual = actual.siguiente;
                }
                actual.siguiente = cabeza.siguiente;
                cabeza = cabeza.siguiente;
            }
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != cabeza) {
            if (actual.siguiente.valor == valor) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }

    // Método buscar
    public boolean buscar(int valor) {
        Nodo actual = cabeza;
        do {
            if (actual.valor == valor) return true;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    // Método imprimir
    public void imprimir() {
        Nodo actual = cabeza;
        if (actual != null) {
            do {
                System.out.print(actual.valor + " ");
                actual = actual.siguiente;
            } while (actual != cabeza);
            System.out.println();
        }
    }

    // Método insertar al inicio
    public void insertarAlInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
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
        if (actual != null) {
            do {
                tamano++;
                actual = actual.siguiente;
            } while (actual != cabeza);
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
        Nodo actual = cabeza;
        while (actual.siguiente != cabeza) {
            actual = actual.siguiente;
        }
        return actual;
    }

    // Método obtener siguiente nodo
    public Nodo getNext(Nodo nodo) {
        return nodo.siguiente;
    }

    // Método modificar
    public void modificar(int valor, int nuevoValor) {
        Nodo actual = cabeza;
        do {
            if (actual.valor == valor) {
                actual.valor = nuevoValor;
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
    }
}





