package seleccion;

public class Masajista extends Personal{
    private String profesion;
    private int aniosExperiencia;
    
    public Masajista(int identificador, String nombre, String apellido, int edad, String profesion,
            int aniosExperiencia) {
        super(identificador, nombre, apellido, edad);
        this.profesion = profesion;
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public void concentrarse() {
        System.out.println("Concentrandose en masaje...");
    }

    @Override
    public void viajar() {
        System.out.println("Viajando al juego...");
    }

    public void darMasaje(){
        System.out.println("Dando masaje...");
    }
}
