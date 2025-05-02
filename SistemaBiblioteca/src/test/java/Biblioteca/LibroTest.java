package Biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LibroTest {

    @Test
    public void testCrearLibro() {
        // Given
        int id = 1;
        String titulo = "Moby Dick";
        String autor = "Herman Melville";
        int anio = 1851;
        String genero = "Aventura";
        boolean disponible = true;
        String formato = "Rustico";

        // When
        Libro nuevoLibro = Libro.crearLibro(id, titulo, autor, anio, genero, disponible, formato);

        // Then
        assertInstanceOf(Libro.class, nuevoLibro);
    }

    @Test
    public void testCrearLibroError() {
        // Given
        int id = 1;
        String titulo = "Moby Dick";
        String autor = "Herman Melville";
        int anio = 1851;
        String genero = "Aventura";
        boolean disponible = true;
        String formato = "Solapas";

        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            Libro nuevoLibro = Libro.crearLibro(id, titulo, autor, anio, genero, disponible, formato);
        });
    }
}
