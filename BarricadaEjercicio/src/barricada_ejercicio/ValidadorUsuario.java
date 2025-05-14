package barricada_ejercicio;

// clase barricada
public class ValidadorUsuario {

    // implementar método: validarCorreo(String correo)
    // aceptar emial que contengan @ y .
    public static String validarCorreo(String correo) {
        String patron = "^[^@]+@[a-z]+\\.[a-z]{2,3}$";

        if (correo.matches(patron)){
            return correo;
        } else {
            return null;
        }
    }

    // implementar método: validarContrasena(String contrasena)
    // constraseña debe tener longitud mayor o igual a 8
    public static String validarContrasenia(String constrasenia) {
        String patron = "^\\S{9,}";
        if (constrasenia.matches(patron)){
            return constrasenia;
        }
        return null;
    }

    // implementar método: validarEdad(String edadTexto)
    // edad debe ser mayor o gual a 15 y menor o igual a 50
    public static Integer validarEdad(String edadTexto) {
        try {
            int edad = Integer.parseInt(edadTexto);
            if (edad < 15 || edad > 50)
                return null;
            return edad;
        } catch (NumberFormatException e) {
            return null; // Valor por defecto en caso de error
        }
    }
}
