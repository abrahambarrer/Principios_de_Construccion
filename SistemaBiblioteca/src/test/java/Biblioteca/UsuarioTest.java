package Biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testCrearUsuario() {
        // Given
        int id = 23017343;
        String nombre = "Abraham Barrera";
        String email = "abrahambarrera072@gmail.com";
        String telefono = "9222834047";
        String rol = "Estudiante";

        // When
        Usuario nuevoUsuario = Usuario.crearUsuario(id, nombre, email, telefono, rol);

        // Then
        assertInstanceOf(Usuario.class, nuevoUsuario);
    }

    @Test
    public void testCrearUsuarioError() {
        // Given
        int id = 23017343;
        String nombre = "Abraham Barrera";
        String email = "abrahambarrera072@gmail.com";
        String telefono = "9222834047";
        String rol = "Empleado";

        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            Usuario nuevoUsuario = Usuario.crearUsuario(id, nombre, email, telefono, rol);
        });
    }
}
