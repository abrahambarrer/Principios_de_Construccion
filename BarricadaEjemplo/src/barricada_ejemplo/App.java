package barricada_ejemplo;

// Clase principal que simula la entrada insegura (fuera de la barricada)
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String entradaNombre = sc.nextLine();

        System.out.print("Ingrese su edad: ");
        String entradaEdad = sc.nextLine();

        // Validación/barricada
        String nombreSeguro = ValidadorEntrada.sanitizarNombre(entradaNombre);
        int edadSegura = ValidadorEntrada.sanitizarEdad(entradaEdad);

        // Zona segura: datos ya validados
        Persona persona = new Persona(nombreSeguro, edadSegura);
        persona.imprimir();

        sc.close();
    }
}
