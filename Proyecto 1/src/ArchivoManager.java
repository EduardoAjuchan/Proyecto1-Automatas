import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ArchivoManager {

    // Método para leer un archivo línea por línea y devolver una lista de cadenas
    public List<String> leerArchivo(String rutaArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + rutaArchivo);
            throw e;
        }

        return lineas;
    }

    // Método para escribir una lista de cadenas en un archivo
    public void escribirArchivo(String rutaArchivo, List<String> contenido) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(rutaArchivo))) {
            for (String linea : contenido) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + rutaArchivo);
            throw e;
        }
    }
}
