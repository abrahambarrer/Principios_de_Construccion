package Biblioteca;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase permite el manejo de libros y usuarios de una biblioteca,
 * se permiten los metodos para registrar un libro, registrar usuario,
 * prestar libro, devolver libro, buscar libro, ver todos los libros,
 * ver todos los usuarios y ver prestamos activos
 * @author Abraham Barrera
 * @version 1.1
 */
public class BibliotecaApp {

    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        // Agregar algunos datos de ejemplo
        BibliotecaApp miBibliioteca = new BibliotecaApp();

        miBibliioteca.inicializarDatos();

        miBibliioteca.menu();
    }

    /**
     * Metodo menu de la aplicacion de la biblioteca
     */
    public void menu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Buscar libros");
            System.out.println("6. Ver todos los libros");
            System.out.println("7. Ver todos los usuarios");
            System.out.println("8. Ver préstamos activos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = inputNumber();

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    buscarLibros();
                    break;
                case 6:
                    mostrarLibros();
                    break;
                case 7:
                    mostrarUsuarios();
                    break;
                case 8:
                    mostrarPrestamosActivos();
                    break;
                case 9:
                    salir = true;
                    System.out.println("¡Sistema de biblioteca! sesión finalizada");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * Metodo de muestra para ver el funcionamiento del sistema
     */
    private void inicializarDatos() {
        // Libros de ejemplo
        libros.add(Libro.crearLibro(1, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Ficción", true, "Rustico"));
        libros.add(Libro.crearLibro(2, "Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", true, "Ebook"));
        libros.add(Libro.crearLibro(3, "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula", true, "Audiolibro"));

        // Usuarios de ejemplo
        usuarios.add(Usuario.crearUsuario(101, "Jose Camacho", "jantonio@gmail.com", "123456789", "Profesor"));
        usuarios.add(Usuario.crearUsuario(102, "Patricia Moreno", "patricia@gmail.com", "987654321", "Profesor"));
    }

    /**
     * Metodo para registrar un nuevo libro solicitando datos desde la consola
     */
    private void registrarLibro() {
        System.out.println("--- REGISTRAR NUEVO LIBRO ---");

        System.out.print("ID: ");
        int id = inputNumber();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Año: ");
        int anio = inputNumber();

        System.out.print("Género: ");
        String genero = scanner.nextLine();

        System.out.print("Formato: ");
        String formato = scanner.nextLine();

        Libro nuevoLibro = Libro.crearLibro(id, titulo, autor, anio, genero, true, formato);
        libros.add(nuevoLibro);

        System.out.println("Libro registrado con éxito.");
    }

    /**
     * Mwroso para registrar un usuario solicitando datos desde la consola
     */
    private void registrarUsuario() {
        System.out.println("--- REGISTRAR NUEVO USUARIO ---");

        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Rol: ");
        String rol = scanner.nextLine();

        Usuario nuevoUsuario = Usuario.crearUsuario(id, nombre, email, telefono, rol);
        usuarios.add(nuevoUsuario);

        System.out.println("Usuario registrado con éxito.");
    }

    /**
     * Metodo para registrar un prestamo solicitando ID del libro y de usuario desde consola
     */
    private void prestarLibro() {
        System.out.println("--- PRESTAR LIBRO ---");

        System.out.print("ID del libro: ");
        int idLibro = inputNumber();

        System.out.print("ID del usuario: ");
        int idUsuario = inputNumber();

        Libro libro = buscarLibroID(idLibro);
        Usuario usuario = buscarUsuarioID(idUsuario);

        if (libro == null) {
            System.out.println("Error: Libro no encontrado.");
            return;
        }

        if (usuario == null) {
            System.out.println("Error: Usuario no encontrado.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("Error: El libro no está disponible actualmente.");
            return;
        }

        // Verificar si el usuario tiene más de 3 libros prestados
        int librosUsuario = contarPrestamosUsuario(idUsuario);

        if (librosUsuario >= 3) {
            System.out.println("Error: El usuario ya tiene 3 libros prestados.");
            return;
        }

        // Realizar el préstamo
        registrarPrestamo(libro, idLibro, idUsuario);
    }

    /**
     * Metodo para la devolucion de un libro mediante el ID del libro
     */
    private void devolverLibro() {
        System.out.println("--- DEVOLVER LIBRO ---");

        System.out.print("ID del libro: ");
        int idLibro = inputNumber();

        // Buscar préstamo activo para este libro
        Prestamo prestamo = buscarPrestamoLibro(idLibro);

        if (prestamo == null) {
            System.out.println("Error: No hay préstamos activos para este libro.");
            return;
        }

        // Marcar préstamo como devuelto
        prestamo.setDevuelto(true);
        prestamo.setFechaDevolucion(new Date());

        // Marcar libro como disponible
        marcarLibroDisponible(idLibro);

        System.out.println("Libro devuelto con éxito.");
    }

    /**
     * Metodo para la busqueda de un libro por titulo, autor o genero
     */
    private void buscarLibros() {
        System.out.println("--- BUSCAR LIBROS ---");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por autor");
        System.out.println("3. Buscar por género");
        System.out.print("Seleccione una opción: ");

        int opcion = inputNumber();

        System.out.print("Ingrese término de búsqueda: ");
        String termino = scanner.nextLine().toLowerCase();

        boolean encontrado = false;

        System.out.println("Resultados:");
        for (Libro libro : libros) {
            boolean coincide = false;

            switch (opcion) {
                case 1:
                    coincide = libro.getTitulo().toLowerCase().contains(termino);
                    break;
                case 2:
                    coincide = libro.getAutor().toLowerCase().contains(termino);
                    break;
                case 3:
                    coincide = libro.getGenero().toLowerCase().contains(termino);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            if (coincide) {
                System.out.println(libro.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron libros que coincidan con la búsqueda.");
        }
    }

    /**
     * Metodo para mostrar los atributos de cada libro registrado como
     * ID, titulo, anio, autor, genero, disponibildad y su formato
     */
    private void mostrarLibros() {
        System.out.println("--- LISTADO DE LIBROS ---");

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

    /**
     * Metodo para mostrar los atributos de cada usuario registrado como
     * ID, nombre, email, telefono y su rol
     */
    private void mostrarUsuarios() {
        System.out.println("--- LISTADO DE USUARIOS ---");

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }

    /**
     * Metodo para mostrar los prestamos activos en el sistema. Se imprimen
     * los detalles como ID, titulo del libro, nombre del usuario y fecha
     */
    public void mostrarPrestamosActivos() {
        System.out.println("--- PRÉSTAMOS ACTIVOS ---");

        boolean hayPrestamos = false;

        for (Prestamo prestamo : prestamos) {
            if (!prestamo.isDevuelto()) {
                Libro libro = buscarLibroID(prestamo.getIdLibro());
                Usuario usuario = buscarUsuarioID(prestamo.getIdUsuario());

                if (libro != null && usuario != null) {
                    imprimirDetallePrestamoActivo(prestamo, libro, usuario);
                    hayPrestamos = true;
                }
            }
        }

        if (!hayPrestamos) {
            System.out.println("No hay préstamos activos.");
        }
    }

    // Cambios

    /**
     * Metodo para recuperar un numero entero desde la consola
     * @return Numero entero ingresado desde la consola
     */
    public int inputNumber() {
        int number = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de linea
        return number;
    }

    /**
     * Metodo para buscar un libro segun su ID
     * @param idLibro El parametro es el ID del libro que se quiere buscar
     * @return Un objeto Libro si se encuentra el libro buscado, de lo contrario se devuelve null
     */
    private Libro buscarLibroID(int idLibro) {
        for (Libro libro : libros) {
            if (libro.getId() == idLibro){
                return libro;
            }
        }
        return null;
    }

    /**
     * Metodo que busca un usuario segun un ID
     * @param idUsuario El parametro es el ID del usuario que se quiere buscar
     * @return Un objeto Usuario si se encuentra el usuario buscado, de lo contrario se devuelve
     * null
     */
    private Usuario buscarUsuarioID(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario){
                return usuario;
            }
        }
        return null;
    }

    /**
     * Metodo que cuenta el numero de prestamos activos de un usuario
     * @param idUsuario El parametro es el ID del usuario del que se quiere contar
     *                  el numero de prestamos activos
     * @return El numero de prestamos activos del usuario
     */
    private int contarPrestamosUsuario(int idUsuario) {
        int librosUsuario = 0;
        for (Prestamo p : prestamos) {
            if (p.getIdUsuario() == idUsuario && !p.isDevuelto()) {
                librosUsuario++;
            }
        }
        return librosUsuario;
    }

    /**
     * Metodo que registra el prestamo para un usuario de un libro
     * @param libro El parametro es el objeto Libro que es prestado
     * @param idLibro El parametro es el ID del libro prestado
     * @param idUsuario El parametro es el ID del usuario que solicita el prestamo
     */
    private void registrarPrestamo(Libro libro, int idLibro, int idUsuario) {
        Date fechaPrestamo = new Date();
        Prestamo nuevoPrestamo = new Prestamo(prestamos.size() + 1, idLibro, idUsuario, fechaPrestamo, null, false);
        prestamos.add(nuevoPrestamo);

        // Marcar libro como no disponible
        libro.setDisponible(false);

        System.out.println("Préstamo realizado con éxito.");
    }

     /**
     * Metodo que busca el prestamo de un libro segun su id
     * @param idLibro El parametro es el ID del libro del cual se busca un prestmamo
     * @return Un objeto Prestamo del libro con el id solicitado, de lo contrario
     * se devuelve null
     */
    private Prestamo buscarPrestamoLibro(int idLibro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdLibro() == idLibro && !prestamo.isDevuelto()) {
                return prestamo;
            }
        }
        return null;
    }

    /**
     * Metodo que cambia el atributo disponible de un libro a true, segun un id
     * @param idLibro El parametro es el id del libro del cual se cambia la disponibilidad
     */
    private void marcarLibroDisponible(int idLibro) {
        buscarLibroID(idLibro).setDisponible(true);
    }

    /**
     * Metodo que imprime en consola los detalles de un prestamo activo
     * @param prestamo El parametro es el objeto Prestamo del cual se imprime informacion
     * @param libro El parametro es el objeto Libro del prestamo activo
     * @param usuario El parametro es el objeto Usuario del prestamo activo
     */
    private void imprimirDetallePrestamoActivo(Prestamo prestamo, Libro libro, Usuario usuario) {
        System.out.println("ID Préstamo: " + prestamo.getId() +
                " | Libro: " + libro.getTitulo() +
                " | Usuario: " + usuario.getNombre() +
                " | Fecha: " + prestamo.getFechaPrestamo());
    }

    /**
     * Metodo publico para agregar un libro al atributo libros del objeto
     * biblioteca
     * @param libro El parametro que declara el libro que se quiere agregar
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Metodo de acceso publico para buscar un libro seegun un id
     * @param idLibro El parametro es el id del libro que se quiere buscar
     * @return un objeto Libro si se encuentra el libro buscado, de lo contrario se devuelve null
     */
    public Libro buscarLibroIDPublico(int idLibro) {
        return buscarLibroID(idLibro);
    }

    /**
     * Metodo publico que busca un usuario segun un ID
     * @param idUsuario El parametro es el ID del usuario que se quiere buscar
     * @return Un objeto Usuario si se encuentra el usuario buscado, de lo contrario se devuelve
     * null
     */
    public Usuario buscarUsuarioIDPublico(int idUsuario) {
        return buscarUsuarioID(idUsuario);
    }

    /**
     * Metodo publico para agregar un usuario
     * @param usuario El parametro es el objeto usuario que se quiere agregar
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Metoto publico para contar el numero de prestamos de un usuario
     * @param idUsuario El parametro id del usuario del que se buscan prestamos
     * @return el numero de prestamos del usuario
     */
    public int contarPrestamosUsuarioPublico(int idUsuario) {
        return contarPrestamosUsuario(idUsuario);
    }

    /**
     * Metodo publico para registrar un prestamo
     * @param libro Es el parametro del libro prestado
     * @param idLibro Es el id del libro prestado
     * @param idUsuario Es el id del usuario que solicita el prestamo
     */
    public void registrarPrestamoPublico(Libro libro, int idLibro, int idUsuario) {
        registrarPrestamo(libro, idLibro, idUsuario);
    }

    /**
     * Metodo para obtener el numero de prestamos
     * @return el numero de prestamos registrados en la biblioteca
     */
    public int getNumeroPrestamos() {
        return prestamos.size();
    }

    /**
     * Metodo publico que busca el prestamo de un libro segun su id
     * @param idLibro El parametro es el ID del libro del cual se busca un prestmamo
     * @return Un objeto Prestamo del libro con el id solicitado, de lo contrario
     * se devuelve null
     */
    public Prestamo buscarPrestamoLibroPublico(int idLibro) {
        return buscarPrestamoLibro(idLibro);
    }

    /**
     * Metodo publico para cambiar el atributo disponible de un libro a true, segun su
     * id
     * @param idLibro El parametro es el id del libro del cual se cambia la disponibilidad
     */
    public void marcarLibroDisponiblePublico(int idLibro) {
        marcarLibroDisponible(idLibro);
    }
}