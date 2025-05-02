package Biblioteca;

/**
 * Esta clase hereda de la clase Usuario, agregando el atributo rol
 * para posibles comportamientos implementables de un estudiante
 */
public class Estudiante extends Usuario{
    private String rol;

    /**
     * Constructor de la clase
     * @param id Es el id del nuevo usuario
     * @param nombre Es el nombre del nuevo usuario
     * @param email El correo electronico del nuevo usuario
     * @param telefono El numero telefonico del nuevo usuario
     * @param rol El rol del usuario
     */
    protected Estudiante(int id, String nombre, String email, String telefono, String rol) {
        super(id, nombre, email, telefono);
        this.rol = rol;
    }

    /**
     * Getter rol
     * @return el rol del usuario
     */
    public String getRol() {
        return rol;
    }

    /**
     * Setter rol
     * @param rol El parametro para modificar el rol del usuario
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Metodo toString del audiolibro
     * @return cadena que extiende al metodo toString de la clase Usuario
     * @see class Usuario
     */
    @Override
    public String toString() {
        return super.toString() + " | Rol: " + this.getRol();
    }
}
