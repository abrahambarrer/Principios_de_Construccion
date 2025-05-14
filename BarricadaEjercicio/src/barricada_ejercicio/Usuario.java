package barricada_ejercicio;

// Clase usuario zona segura
public class Usuario {
    String correo;
    String contrasenia;
    int edad;

    // implementar constructor: Usuario(String correo, String contrasena, int edad)
    public Usuario(String correo, String contrasenia, int edad) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.edad = edad;
    }

    // implementar método: mostrarInfo()
    public void mostrarInfo() {
        System.out.println("Correo: " + this.correo);
        System.out.println("Contrasenia: " + this.contrasenia);
        System.out.println("Edad: " + edad);
    }
}
