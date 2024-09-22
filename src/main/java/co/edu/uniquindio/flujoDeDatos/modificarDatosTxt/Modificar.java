package co.edu.uniquindio.flujoDeDatos.modificarDatosTxt;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Modificar {

        private static final String RUTA_ARCHIVO = "src/main/resources/flujoDatos/cedulaContrasenas";

        // Método para modificar la contraseña
        public static void modificarContraseña(String cedula, String nuevaContraseña) throws IOException {
            // Leer todas las líneas del archivo
            List<String> lineas = Files.readAllLines(Paths.get(RUTA_ARCHIVO));
            List<String> nuevasLineas = new ArrayList<>();

            // Bandera para verificar si se encontró la cédula
            boolean encontrado = false;

            // Iterar sobre cada línea para encontrar la cédula
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                if (datos[0].equals(cedula)) {
                    // Si la cédula coincide, cambiar la contraseña
                    nuevasLineas.add(cedula + ";" + nuevaContraseña);
                    encontrado = true;
                } else {
                    // Si no coincide, mantener la línea original
                    nuevasLineas.add(linea);
                }
            }

            if (encontrado) {
                Files.write(Paths.get(RUTA_ARCHIVO), nuevasLineas);
                System.out.println("Contraseña modificada exitosamente.");
            } else {
                System.out.println("Cédula no encontrada.");
            }
        }

        public static void main(String[] args) {
            try {

                modificarContraseña("123", "hola");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


