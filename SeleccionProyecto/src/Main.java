import seleccion.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Futbolista futbolista1 = new Futbolista(1,"Carlos","Vela", 20, 2, "Delantero");

        Entrenador entrenador1 = new Entrenador(2,"Miguel","Patraca",20, 12);

        Masajista masajista1 = new Masajista(3,"Pedro", "Alonso", 30, "Fisioterapeuta", 2);

        entrenador1.dirigirEntrenamiento();
        futbolista1.entrenar();
        futbolista1.concentrarse();
        masajista1.darMasaje();

        try {
			for (int i = 0; i < 2; i++) {
				System.out.print(i + " ");
				System.out.println(1 / 0);
			}
		}
		catch (Exception ex) {
		}
    }
}