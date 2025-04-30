public class Rustico extends Libro{
    private String formato;

    protected Rustico(int id, String titulo, String autor, int anio, String genero, boolean disponible, String formato){
        super(id, titulo, autor, anio, genero, disponible);
        this.formato = formato;
    }

    @Override
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return super.toString() + " | Formato: " + this.getFormato();
    }
}
