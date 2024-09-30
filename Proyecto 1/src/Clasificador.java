import java.util.*;

public class Clasificador {

    // Lista de expresiones regulares para la clasificación
    private List<ExpresionRegular> expresionesRegulares;

    // Constructor que inicializa la lista de expresiones regulares
    public Clasificador(List<ExpresionRegular> expresionesRegulares) {
        this.expresionesRegulares = expresionesRegulares;
    }

    // Método que clasifica una cadena y retorna el nombre de la categoría o "ERROR" si no coincide con ninguna expresión
    public String clasificar(String cadena) {
        for (ExpresionRegular expresion : expresionesRegulares) {
            if (expresion.coincide(cadena)) {
                return expresion.getNombreCategoria(); // Retorna el nombre de la categoría si coincide
            }
        }
        return "ERROR"; // Si no coincide con ninguna, retorna "ERROR"
    }
}
