package co.edu.uniquindio.productorConsumidor.BuscarEnArchivoPunto1;

public class Main {

    public static void main(String[] args) {

        String directorio = "\\main\\java\\co\\edu\\uniquindio\\BuscarEnArchivoPunto1";

        String palabraABuscar = "palabra";


        BuscadorArchivos buscador = new BuscadorArchivos(directorio, palabraABuscar);


        Thread hiloBusqueda = new Thread(buscador);
        hiloBusqueda.start();

        try {

            hiloBusqueda.join();

            int cantidadArchivos = buscador.getCantidadArchivosEncontrados();
            System.out.println("Cantidad de archivos que contienen la palabra '" + palabraABuscar + "': " + cantidadArchivos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
