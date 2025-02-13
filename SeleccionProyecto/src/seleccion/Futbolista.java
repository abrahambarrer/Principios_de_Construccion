package seleccion;

public class Futbolista extends Personal {
    private int numeroJugador;
    private String posicionEnCancha;

    public Futbolista(int identificador, String nombre, String apellido, int edad, int numeroJugador,
            String posicionEnCancha) {
        super(identificador, nombre, apellido, edad);
        this.numeroJugador = numeroJugador;
        this.posicionEnCancha = posicionEnCancha;
    }

    /* Regla 6.1 @Override always used
     * Siempre se utiliza la notacion @Override al sobrescribir metodos de una clase padre
     */
    @Override
    public void concentrarse() {
        System.out.println("Concentrandose en juego...");
    }

    @Override
    public void viajar() {
        System.out.println("Viajando al juego...");
    }

    public void jugarPartido(){
        System.out.println("Jugando...");
    }

    public void entrenar(){
        System.out.println("Entrenando...");
    }
}
