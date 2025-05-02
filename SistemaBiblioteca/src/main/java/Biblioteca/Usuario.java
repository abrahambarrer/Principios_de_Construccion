package Biblioteca;

/**
 * Esta clase abstracta contiene la informacion de un usuario registrado en la biblioteca.
 * Tiene los getters y setter de cada atributo.
 * @author Abraham
 * @version 1.0
 */
public abstract class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String telefono;

    /**
     * Constructor de la clase
     * @param id Es el id del nuevo usuario
     * @param nombre Es el nombre del nuevo usuario
     * @param email El correo electronico del nuevo usuario
     * @param telefono El numero telefonico del nuevo usuario
     */
    protected Usuario(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     * Metodo estatico que permite la creacion de objetos que heredan de la clase abstracta
     * Usuario actual. Se utiilza el parametro rol para identificar cual subclase crear
     * @param id El id del nuevo usuario
     * @param nombre El nombre del nuevo usuario
     * @param email El correo electronico del nuevo usuario
     * @param telefono El numero telefonico del nuevo usuario
     * @param rol El rol del nuevo usuario que distingue a cada subclase
     * @return Un objeto de tipo Usuario
     * @throws IllegalArgumentException si el parametro rol no es reconocido
     */
    public static Usuario crearUsuario(int id, String nombre, String email, String telefono, String rol) {
        if (rol.equalsIgnoreCase("profesor")) {
            return new Profesor(id, nombre, email, telefono, rol);
        } else if (rol.equalsIgnoreCase("estudiante")) {
            return new Estudiante(id, nombre, email, telefono, rol);
        } else {
            throw new IllegalArgumentException("Rol de usuario invalido: " + rol);
        }
    }

    /**
     * Metodo abstracto getter rol para las subclases
     * @return el rol del usuario
     */
    public abstract String getRol();

    /**
     * Metodo abstracto setter rol para las subclases
     * @param rol El parametro para modificar el rol del usuario
     */
    public abstract void setRol(String rol);

    // Getters y setters

    /**
     * Getter id
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Setter id
     * @param id El parametro id para modificar el id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter nombre
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter nombre
     * @param nombre El parametro nombre para modificar el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter email
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter email
     * @param email El parametro email para modificar el correo electronico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter telefono
     * @return cadena con el numero de telefono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter telefono
     * @param telefono El parametro para modificar el numero de telefono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo toString del usuario
     * @return cadena con detalles del usuario
     */
    @Override
    public String toString() {
        return "ID: " + this.getId() + " | Nombre: " + this.getNombre() +
                " | Email: " + this.getEmail() + " | Teléfono: " + this.getTelefono();
    }
}