package co.edu.uniquindio.flujoDeDatos.leerDatosTxt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class leer {

    // Lee el archivo y devuelve un ArrayList
    //parte.trim()=para eliminar espacios antes o despues de la coma
    public static ArrayList<String> leerArchivo(String ruta) throws IOException {
        ArrayList<String> contenido = new ArrayList<String>();
        FileReader fr = new FileReader(ruta);
        BufferedReader bfr = new BufferedReader(fr);
        String linea = "";
        while ((linea = bfr.readLine()) != null) {
            String[] partes = linea.split(","); // Divide la línea en partes usando coma como delimitador
            for (String parte : partes) {
                contenido.add(parte.trim()); // Añade cada parte al ArrayList
            }
        }
        bfr.close();
        fr.close();
        return contenido;
    }

    // Convierte el ArrayList a un array
    public static String[] archivosAVector(ArrayList<String> archivo) {
        String[] datos = new String[archivo.size()];
        for (int i = 0; i < archivo.size(); i++) {
            datos[i] = archivo.get(i);
        }
        return datos;
    }

    public static void main(String[] args) {
        try {
            String ruta = "ruta/a/tu/archivo.txt"; // Reemplaza con la ruta correcta
            ArrayList<String> contenido = leerArchivo(ruta);
            String[] datos = archivosAVector(contenido);
            for (String dato : datos) {
                System.out.println(dato);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
