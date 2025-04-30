// Libro.java
public abstract class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private boolean disponible;

    protected Libro(int id, String titulo, String autor, int anio, String genero, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.disponible = disponible;
    }

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

    public abstract String getFormato();

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " | Título: " + this.getTitulo() + 
        " | Autor: " + this.getAutor() + " | Año: " + this.getAnio() + 
        " | Género: " + this.getGenero() + 
        " | Disponible: " + (this.isDisponible() ?"Sí" : "No");
    }
}
