package co.edu.uniquindio.estructuraDeDatos.listasEnlazadas.listaCircularDoblementeEnlazada;

public class ListaCircularDoblementeEnlazada {


        private Nodo cabeza;

        // Método agregar
        public void agregar(int valor) {
            Nodo nuevo = new Nodo(valor);
            if (cabeza == null) {
                cabeza = nuevo;
                cabeza.anterior = cabeza;
                cabeza.siguiente = cabeza;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != cabeza) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
                nuevo.anterior = actual;
                nuevo.siguiente = cabeza;
                cabeza.anterior = nuevo;
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
                    cabeza.siguiente.anterior = actual;
                    cabeza = cabeza.siguiente;
                }
                return;
            }
            Nodo actual = cabeza;
            while (actual.siguiente != cabeza) {
                if (actual.siguiente.valor == valor) {
                    actual.siguiente = actual.siguiente.siguiente;
                    actual.siguiente.anterior = actual;
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

        // Método imprimir inverso
        public void imprimirInverso() {
            Nodo actual = cabeza;
            if (actual != null) {
                while (actual.siguiente != cabeza) {
                    actual = actual.siguiente;
                }
                do {
                    System.out.print(actual.valor + " ");
                    actual = actual.anterior;
                } while (actual != cabeza);
                System.out.println();
            }
        }

        // Método insertar al inicio
        public void insertarAlInicio(int valor) {
            Nodo nuevo = new Nodo(valor);
            if (cabeza == null) {
                cabeza = nuevo;
                cabeza.anterior = cabeza;
                cabeza.siguiente = cabeza;
            } else {
                Nodo actual = cabeza;
                while (actual.anterior != cabeza) {
                    actual = actual.anterior;
                }
                actual.anterior = nuevo;
                nuevo.siguiente = cabeza;
                nuevo.anterior = actual;
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

        // Método obtener nodo anterior
        public Nodo getAnterior(Nodo nodo) {
            return nodo.anterior;
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



