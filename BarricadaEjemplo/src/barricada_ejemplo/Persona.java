package barricada_ejemplo;

// Clase que representa datos ya validados (zona segura)
public class Persona {
    private final String nombre;
    private final int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}
