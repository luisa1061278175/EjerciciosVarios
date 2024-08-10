package co.edu.uniquindio.productorConsumidor.BuscarEnArchivoPunto1;

import java.io.File;

class BuscadorArchivos implements Runnable {
    private String directorio;
    private String palabraABuscar;
    private int cantidadArchivosEncontrados;


    public BuscadorArchivos(String directorio, String palabraABuscar) {
        this.directorio = directorio;
        this.palabraABuscar = palabraABuscar;
        this.cantidadArchivosEncontrados = 0;
    }


    @Override
    public void run() {
        buscarArchivos(new File(directorio));
    }


    private void buscarArchivos(File directorioActual) {

        File[] archivos = directorioActual.listFiles();

        if (archivos != null) {

            for (File archivo : archivos) {
                if (archivo.isDirectory()) {

                    buscarArchivos(archivo);
                } else if (archivo.isFile() && archivo.getName().endsWith(".txt")) {

                    if (buscarPalabraEnArchivo(archivo, palabraABuscar)) {
                        cantidadArchivosEncontrados++;
                    }
                }
            }
        }
    }

    private boolean buscarPalabraEnArchivo(File archivo, String palabraABuscar) {

        return false;
    }

    public int getCantidadArchivosEncontrados() {
        return cantidadArchivosEncontrados;
    }
}