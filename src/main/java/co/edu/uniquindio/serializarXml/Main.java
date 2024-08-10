package co.edu.uniquindio.serializarXml;

import co.edu.uniquindio.serializarXml.PersistenciaXML;
import co.edu.uniquindio.serializarXml.Persona;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", "Pérez");
        String fileNameXML = "persona.xml";

        try {
            // Serialización XML
            PersistenciaXML.salvarRecursoSerializadoXML(fileNameXML, persona);

            // Deserialización XML
            Persona personaXML = (Persona) PersistenciaXML.cargarRecursoSerializadoXML(fileNameXML);
            System.out.println("Persona deserializada (XML): " + personaXML);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
