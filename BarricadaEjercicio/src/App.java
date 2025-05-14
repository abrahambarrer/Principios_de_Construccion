import barricada_ejercicio.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Leer correo, contraseña y edad
        System.out.print("Ingrese su correo: ");
        String entradaCorreo = input.nextLine();

        System.out.print("Ingrese su contrasenia: ");
        String entradaContrasenia = input.nextLine();

        System.out.print("Ingrese su edad: ");
        String entradaEdad = input.nextLine();

        // Validación (barricada)
        String correo = ValidadorUsuario.validarCorreo(entradaCorreo);
        String contrasenia = ValidadorUsuario.validarContrasenia(entradaContrasenia);
        Integer edad = ValidadorUsuario.validarEdad(entradaEdad);

        // Guardar datos en objeto usuario en caso que todos los datos sean válidos
        // de lo contrario indicar mensaje de error 
        Usuario usuario = new Usuario(correo, contrasenia, edad);
        usuario.mostrarInfo();
        input.close();
    }
}
