package seleccion;

public class Entrenador extends Personal {
    private int idFederacion;

    public Entrenador(int identificador, String nombre, String apellido, int edad, int idFederacion) {
        super(identificador, nombre, apellido, edad);
        this.idFederacion = idFederacion;
    }

    @Override
    public void concentrarse() {
        System.out.println("Concentrandose en entrenamiento...");
    }

    @Override
    public void viajar() {
        System.out.println("Viajando al juego...");
    }

    public void dirigirPartido(){
        System.out.println("Dirigiendo partido...");
    }

    public void dirigirEntrenamiento(){
        System.out.println("Dirigiendo entrenamiento...");
    }
}
