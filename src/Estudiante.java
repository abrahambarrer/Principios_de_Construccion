public class Estudiante extends Usuario{
    private String rol;

    protected Estudiante(int id, String nombre, String email, String telefono, String rol) {
        super(id, nombre, email, telefono);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return super.toString() + " | Rol: " + this.getRol();
    }
}
