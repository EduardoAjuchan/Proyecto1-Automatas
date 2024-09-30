import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Ruta de los archivos
        String rutaEntrada = "C:\\Users\\eduar\\Desktop\\Proyecto 1 - Automatas\\Entrada.txt";
        String rutaExpresion = "C:\\Users\\eduar\\Desktop\\Proyecto 1 - Automatas\\Expresión.txt";
        String rutaSalida = "C:\\Users\\eduar\\Desktop\\Proyecto 1 - Automatas\\Salida.txt";

        // Instancia de ArchivoManager para manejar lectura y escritura de archivos
        ArchivoManager archivoManager = new ArchivoManager();

        try {
            // 1. Lectura del archivo de entrada
            List<String> lineasEntrada = archivoManager.leerArchivo(rutaEntrada);

            // 2. Lectura del archivo de expresiones regulares
            List<String> lineasExpresion = archivoManager.leerArchivo(rutaExpresion);

            // 3. Crear la lista de ExpresionRegular a partir del archivo de expresiones
            List<ExpresionRegular> expresionesRegulares = new ArrayList<>();
            for (String linea : lineasExpresion) {
                // Separar la línea por el signo igual "=", el formato es NOMBRE_CATEGORIA = "EXPRESION_REGULAR"
                String[] partes = linea.split(" = ");
                if (partes.length == 2) {
                    String nombreCategoria = partes[0].trim();
                    String expresionRegular = partes[1].trim().replaceAll("\"", ""); // Remueve las comillas de la expresión

                    // Aquí hacemos el reemplazo de \\ por \
                    expresionRegular = expresionRegular.replaceAll("\\\\\\\\", "\\\\");

                    expresionesRegulares.add(new ExpresionRegular(nombreCategoria, expresionRegular));
                }
            }

            // 4. Crear una instancia del clasificador
            Clasificador clasificador = new Clasificador(expresionesRegulares);

            // 5. Clasificar las cadenas del archivo de entrada y preparar el resultado
            List<String> resultados = new ArrayList<>();
            for (String cadena : lineasEntrada) {
                String resultado = cadena + " - " + clasificador.clasificar(cadena);
                resultados.add(resultado); // Agregar el resultado a la lista
            }

            // 6. Escribir el resultado en el archivo de salida
            archivoManager.escribirArchivo(rutaSalida, resultados);

            // Mensaje final
            System.out.println("Clasificación completada. El archivo de salida se ha generado en: " + rutaSalida);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al procesar los archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
