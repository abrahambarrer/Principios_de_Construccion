// Usuario.java
public abstract class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String telefono;

    protected Usuario(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public static Usuario crearUsuario(int id, String nombre, String email, String telefono, String rol) {
        if (rol.equalsIgnoreCase("profesor")) {
            return new Profesor(id, nombre, email, telefono, rol);
        } else if (rol.equalsIgnoreCase("estudiante")) {
            return new Estudiante(id, nombre, email, telefono, rol);
        } else {
            throw new IllegalArgumentException("Rol de usuario invalido: " + rol);
        }
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " | Nombre: " + this.getNombre() + 
        " | Email: " + this.getEmail() + " | Teléfono: " + this.getTelefono();
    }
}
