package Biblioteca;

/**
 * Esta clase hereda de la clase libro, agregando el atributo formato
 * para posibles comportamientos implementablesde un libro rustico
 */
public class Rustico extends Libro{
    private String formato;

    /**
     * Constructor de la clase
     * @param id El id del audiolibro
     * @param titulo El titulo del audiolibro
     * @param autor Es el autor del audiolibro
     * @param anio Es el anio original de publicacion del audiolibro
     * @param genero Es el genero del audiolibro
     * @param disponible Es el estado de disponibilidad del audiolibro
     * @param formato El formato del libro
     */
    protected Rustico(int id, String titulo, String autor, int anio, String genero, boolean disponible, String formato){
        super(id, titulo, autor, anio, genero, disponible);
        this.formato = formato;
    }

    /**
     * Geter formato
     * @return el formato del libro
     */
    @Override
    public String getFormato() {
        return formato;
    }

    /**
     * Setter formato
     * @param formato El parametro para modificar el formato del libro
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Metodo toString del audiolibro
     * @return cadena que extiende al metodo toString de la clase Libro
     * @see class Libro
     */
    @Override
    public String toString() {
        return super.toString() + " | Formato: " + this.getFormato();
    }
}