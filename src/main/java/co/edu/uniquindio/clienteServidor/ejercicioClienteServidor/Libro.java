package co.edu.uniquindio.clienteServidor.ejercicioClienteServidor;

public class Libro {
    String titulo;
    String autor;
    boolean disponible;

    public Libro(String titulo, String autor, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + (disponible ? "Disponible" : "No disponible") + ")";
    }
}
