import java.util.regex.*;

public class ExpresionRegular {

    private String nombreCategoria; // Nombre de la categoría (por ejemplo, FECHA_CORTA_NUMEROS)
    private Pattern patron; // El patrón de la expresión regular compilado

    // Constructor que toma el nombre de la categoría y el patrón de la expresión
    public ExpresionRegular(String nombreCategoria, String expresionRegular) {
        this.nombreCategoria = nombreCategoria;
        this.patron = Pattern.compile(expresionRegular); // Compila la expresión regular
    }

    // Método que verifica si la cadena coincide con la expresión regular
    public boolean coincide(String cadena) {
        Matcher matcher = patron.matcher(cadena); // Crea un matcher para la cadena
        return matcher.matches(); // Retorna true si coincide completamente
    }

    // Getter para obtener el nombre de la categoría
    public String getNombreCategoria() {
        return nombreCategoria;
    }
}
