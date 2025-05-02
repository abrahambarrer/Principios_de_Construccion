package Biblioteca;

/**
 * La clase abstracta libro contiene la informacion relativa a un libro de la biblioteca,
 * asi como sus metodos getters y setters
 */
public abstract class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private boolean disponible;

    /**
     * Constructor de la clase libro
     * @param id Es el id del nuevo libro
     * @param titulo Es el titulo del nuevo libro
     * @param autor Es el autor del nuevo libro
     * @param anio Es el anio original de publicacion del nuevo libro
     * @param genero Es el genero del nuevo libro
     * @param disponible Es el estado de disponibilidad del nuevo libro
     */
    protected Libro(int id, String titulo, String autor, int anio, String genero, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.disponible = disponible;
    }

    /**
     * Metodo estatico que permite la creacion de objetos que heredan de la clase abstracta
     * Libro actual. Se utiilza el parametro formato para identificar cual subclase crear
     * @param id Es el id del nuevo libro
     * @param titulo Es el titulo del nuevo libro
     * @param autor Es el autor del nuevo libro
     * @param anio Es el anio original de publicacion del nuevo libro
     * @param genero Es el genero del nuevo libro
     * @param disponible Es el estado de disponibilidad del nuevo libro
     * @param formato El formato de cada libro que distingue a cada subclase
     * @return un objeto de tipo Libro
     */
    public static Libro crearLibro(int id, String titulo, String autor, int anio, String genero, boolean disponible, String formato) {
        if (formato.equalsIgnoreCase("ebook")){
            return new Ebook(id, titulo, autor, anio, genero, disponible, formato);
        } else if (formato.equalsIgnoreCase("rustico")) {
            return new Rustico(id, titulo, autor, anio, genero, disponible, formato);
        } else if (formato.equalsIgnoreCase("audiolibro")) {
            return new Rustico(id, titulo, autor, anio, genero, disponible, formato);
        } else {
            throw new IllegalArgumentException("Tipo de libro desconocido: " + formato);
        }
    }

    /**
     * Metodo abstracto getter formato para las subclases
     * @return el formato del libro
     */
    public abstract String getFormato();

    /**
     * Metodo abstracto setter formato para las subclases
     * @param formato El parametro para modificar el formato del libro
     */
    public abstract void setFormato(String formato);

    // Getters y setters

    /**
     * Getter id
     * @return el id del libro
     */
    public int getId() {
        return id;
    }

    /**
     * Setter id
     * @param id El parametro para modificar el id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter titulo
     * @return el titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter titulo
     * @param titulo El parametro para modificar el titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter autor
     * @return el autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Setter autor
     * @param autor El parametro para modificar el autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Getter anio
     * @return el anio de publicacion del libro
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Setter anio
     * @param anio El parametro para modificar el anio de publicacion del libro
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Getter genero
     * @return el genero del libro
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Setter genero
     * @param genero El parametro para modificar el genero del libro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Getter disponible
     * @return el estado disponibilidad del libro
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Setter disponible
     * @param disponible El parametro para modificar el estado de disponibilidad
     *                   del libro
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Metodo toString del libro
     * @return cadena con detalles del libro
     */
    @Override
    public String toString() {
        return "ID: " + this.getId() + " | Título: " + this.getTitulo() +
                " | Autor: " + this.getAutor() + " | Año: " + this.getAnio() +
                " | Género: " + this.getGenero() +
                " | Disponible: " + (this.isDisponible() ?"Sí" : "No");
    }
}
