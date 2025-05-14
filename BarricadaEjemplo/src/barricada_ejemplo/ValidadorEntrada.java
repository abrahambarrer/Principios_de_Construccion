package barricada_ejemplo;

// Clase que actúa como barricada: valida y limpia los datos
public class ValidadorEntrada {

    public static String sanitizarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return "Desconocido";
        }
        // Elimina caracteres no alfabéticos
        return nombre.trim().replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ ]", "");
    }

    public static int sanitizarEdad(String edadTexto) {
        try {
            int edad = Integer.parseInt(edadTexto);
            if (edad < 0)
                return 0;
            if (edad > 120)
                return 120;
            return edad;
        } catch (NumberFormatException e) {
            return 0; // Valor por defecto en caso de error
        }
    }
}
