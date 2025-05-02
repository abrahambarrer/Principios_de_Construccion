package Biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BibliotecaAppTest {

    @Test
    public void testBuscarLibroID() {
        // Given
        int id = 1;
        String titulo = "Rayuela";
        String autor = "Julio Cortazar";
        int anio = 1963;
        String genero = "Ficcion";
        boolean disponible = true;
        String formato = "Rustico";

        BibliotecaApp biblioteca1 = new BibliotecaApp();
        Libro nuevoLibro = Libro.crearLibro(id, titulo, autor, anio, genero, true, formato);
        biblioteca1.agregarLibro(nuevoLibro);

        // When
        Libro resultado = biblioteca1.buscarLibroIDPublico(1);

        // Then
        assertInstanceOf(Libro.class, resultado);
        assertNotNull(resultado);
    }

    @Test
    public void testBuscarLibroIDNull() {
        // Given
        BibliotecaApp biblioteca2 = new BibliotecaApp();

        // When
        Libro resultado = biblioteca2.buscarLibroIDPublico(15);

        // Then
        assertNull(resultado);
    }

    @Test
    public void testBuscarUsuarioID() {
        // Given
        int id = 23017343;
        String nombre = "Abraham Barrera";
        String email = "abrahambarrera072@gmail.com";
        String telefono = "9222834047";
        String rol = "Estudiante";

        BibliotecaApp biblioteca3 = new BibliotecaApp();
        Usuario nuevoUsuario = Usuario.crearUsuario(id, nombre, email, telefono, rol);
        biblioteca3.agregarUsuario(nuevoUsuario);

        // When
        Usuario resultado = biblioteca3.buscarUsuarioIDPublico(23017343);

        // Then
        assertInstanceOf(Usuario.class, resultado);
        assertNotNull(resultado);
    }

    @Test
    public void testBuscarUsuarioIDNull() {
        // Given
        BibliotecaApp biblioteca4 = new BibliotecaApp();

        // When
        Usuario resultado = biblioteca4.buscarUsuarioIDPublico(0);

        // Then
        assertNull(resultado);
    }

    @Test
    public void testRegistrarPrestamo() {
        // Given
        int idUsuario = 230173657;
        String nombre = "Abraham Barrera";
        String email = "abrahambarrera072@gmail.com";
        String telefono = "9222834047";
        String rol = "Estudiante";

        BibliotecaApp biblioteca5 = new BibliotecaApp();
        Usuario nuevoUsuario = Usuario.crearUsuario(idUsuario, nombre, email, telefono, rol);
        biblioteca5.agregarUsuario(nuevoUsuario);

        int idLibro = 18;
        String titulo = "El viejo y el mar";
        String autor = "Ernest Hemingway";
        int anio = 1952;
        String genero = "Aventura";
        boolean disponible = true;
        String formato = "Rustico";

        Libro nuevoLibro = Libro.crearLibro(idLibro, titulo, autor, anio, genero, disponible, formato);
        biblioteca5.agregarLibro(nuevoLibro);

        // When
        biblioteca5.registrarPrestamoPublico(nuevoLibro, idLibro, idUsuario);
        int resultado = biblioteca5.getNumeroPrestamos();

        // Then
        assertEquals(1, resultado);
    }

    @Test
    public void testContarPrestamosUsuario() {
        // Given
        int idUsuario = 23017378;
        String nombre = "Abraham Barrera";
        String email = "abrahambarrera072@gmail.com";
        String telefono = "9222834047";
        String rol = "Estudiante";

        BibliotecaApp biblioteca6 = new BibliotecaApp();
        Usuario nuevoUsuario = Usuario.crearUsuario(idUsuario, nombre, email, telefono, rol);
        biblioteca6.agregarUsuario(nuevoUsuario);

        int idLibro = 1;
        String titulo = "Cuna de gato";
        String autor = "Kurt Vonnegut";
        int anio = 1963;
        String genero = "Ciencia Ficcion";
        boolean disponible = true;
        String formato = "Rustico";

        Libro nuevoLibro = Libro.crearLibro(idLibro, titulo, autor, anio, genero, true, formato);
        biblioteca6.agregarLibro(nuevoLibro);

        // When
        biblioteca6.registrarPrestamoPublico(nuevoLibro, idLibro, idUsuario);
        int resultado = biblioteca6.contarPrestamosUsuarioPublico(idUsuario);

        // Then
        assertEquals(1, resultado);
    }

    @Test
    public void testBuscarPrestamoLibro() {
        // Given
        int idUsuario = 23017343;
        String nombre = "Abraham Barrera";
        String email = "abrahambarrera072@gmail.com";
        String telefono = "9222834047";
        String rol = "Estudiante";

        BibliotecaApp biblioteca7 = new BibliotecaApp();
        Usuario nuevoUsuario = Usuario.crearUsuario(idUsuario, nombre, email, telefono, rol);
        biblioteca7.agregarUsuario(nuevoUsuario);

        int idLibro = 20;
        String titulo = "Un mundo feliz";
        String autor = "Aldous Huxley";
        int anio = 1932;
        String genero = "Aventura";
        boolean disponible = true;
        String formato = "Rustico";

        Libro nuevoLibro = Libro.crearLibro(idLibro, titulo, autor, anio, genero, true, formato);
        biblioteca7.agregarLibro(nuevoLibro);

        biblioteca7.registrarPrestamoPublico(nuevoLibro, idLibro, idUsuario);

        // When
        Prestamo resultado = biblioteca7.buscarPrestamoLibroPublico(idLibro);

        // Then
        assertInstanceOf(Prestamo.class, resultado);
        assertNotNull(resultado);
    }

    @Test
    public void testBuscarPrestamoLibroNull() {
        // Given
        BibliotecaApp biblioteca8 = new BibliotecaApp();

        // When
        Prestamo resultado = biblioteca8.buscarPrestamoLibroPublico(15);

        // Then
        assertNull(resultado);
    }

    @Test
    public void testMarcarLibroDisponible() {
        // Given
        int id = 1;
        String titulo = "La gran novela americana";
        String autor = "Philip Roth";
        int anio = 1972;
        String genero = "Humor";
        boolean disponible = false;
        String formato = "Rustico";

        Libro nuevoLibro = Libro.crearLibro(id, titulo, autor, anio, genero, disponible, formato);
        BibliotecaApp biblioteca9 = new BibliotecaApp();
        biblioteca9.agregarLibro(nuevoLibro);

        // When
        biblioteca9.marcarLibroDisponiblePublico(id);
        boolean resultado = biblioteca9.buscarLibroIDPublico(id).isDisponible();

        // Then
        assertTrue(resultado);

    }
}
