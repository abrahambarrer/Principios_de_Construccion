import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        // Agregar algunos datos de ejemplo
        inicializarDatos();
        
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

    private static void inicializarDatos() {
        // Libros de ejemplo
        libros.add(Libro.crearLibro(1, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Ficción", true, "Rustico"));
        libros.add(Libro.crearLibro(2, "Cien años de soledad", "Gabriel García Márquez", 1967, "Novela", true, "Ebook"));
        libros.add(Libro.crearLibro(3, "El principito", "Antoine de Saint-Exupéry", 1943, "Fábula", true, "Audiolibro"));
        
        // Usuarios de ejemplo
        usuarios.add(Usuario.crearUsuario(101, "Jose Camacho", "jantonio@gmail.com", "123456789", "Profesor"));
        usuarios.add(Usuario.crearUsuario(102, "Patricia Moreno", "patricia@gmail.com", "987654321", "Profesor"));
    }

    private static void registrarLibro() {
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

    private static void registrarUsuario() {
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

    private static void prestarLibro() {
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

    private static void devolverLibro() {
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

    private static void buscarLibros() {
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

    private static void mostrarLibros() {
        System.out.println("--- LISTADO DE LIBROS ---");
        
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

    private static void mostrarUsuarios() {
        System.out.println("--- LISTADO DE USUARIOS ---");
        
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }

    private static void mostrarPrestamosActivos() {
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

    private static int inputNumber() {
        int number = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de linea
        return number;
    }

    private static Libro buscarLibroID(int idLibro) {
        for (Libro libro : libros) {
            if (libro.getId() == idLibro){
                return libro;
            }
        }
        return null;
    }

    private static Usuario buscarUsuarioID(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario){
                return usuario;
            }
        }
        return null;
    }

    private static int contarPrestamosUsuario(int idUsuario) {
        int librosUsuario = 0;
        for (Prestamo p : prestamos) {
            if (p.getIdUsuario() == idUsuario && !p.isDevuelto()) {
                librosUsuario++;
            }
        }
        return librosUsuario;
    }

    private static void registrarPrestamo(Libro libro, int idLibro, int idUsuario) {
        Date fechaPrestamo = new Date();
        Prestamo nuevoPrestamo = new Prestamo(prestamos.size() + 1, idLibro, idUsuario, fechaPrestamo, null, false);
        prestamos.add(nuevoPrestamo);
        
        // Marcar libro como no disponible
        libro.setDisponible(false);

        System.out.println("Préstamo realizado con éxito.");
    }

    private static Prestamo buscarPrestamoLibro(int idLibro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdLibro() == idLibro && !prestamo.isDevuelto()) {
                return prestamo;
            }
        }
        return null;
    }

    private static void marcarLibroDisponible(int idLibro) {
        buscarLibroID(idLibro).setDisponible(true);
    }

    private static void imprimirDetallePrestamoActivo(Prestamo prestamo, Libro libro, Usuario usuario) {
        System.out.println("ID Préstamo: " + prestamo.getId() + 
        " | Libro: " + libro.getTitulo() + 
        " | Usuario: " + usuario.getNombre() + 
        " | Fecha: " + prestamo.getFechaPrestamo());
    }
}