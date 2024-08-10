package co.edu.uniquindio.flujoDeDatos.escribirDatosTxt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Escribir {
    private static ArrayList<Character> auxiliar = new ArrayList<>();
    public void escribirLetrasSobrantes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("datosTxt/letrasSobrantes.txt", true))) {
            for (char c : auxiliar) {
                writer.print(c);
            }
            auxiliar.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
