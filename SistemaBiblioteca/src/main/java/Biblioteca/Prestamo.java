package Biblioteca;

import java.util.Date;

/**
 * Esta clase contiene la informacion relativa a un prestamo realizado para un usuario
 * de un libro, asi como sus getters y setters
 */
public class Prestamo {
    private int id;
    private int idLibro;
    private int idUsuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    /**
     * Constructor de la clase
     * @param id El id del nuevo prestamo
     * @param idLibro El id del libro prestado
     * @param idUsuario El id del usuario que solicita el prestamo
     * @param fechaPrestamo La fecha de emision del prestamo
     * @param fechaDevolucion La fecha de devolucion del libro
     * @param devuelto El estado de devolucion actual del prestamo
     */
    public Prestamo(int id, int idLibro, int idUsuario, Date fechaPrestamo, Date fechaDevolucion, boolean devuelto) {
        this.id = id;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    // Getters y setters

    /**
     * Getter id
     * @return el id del prestamo
     */
    public int getId() {
        return id;
    }

    /**
     * Setter id
     * @param id El parametro para modificar el id del prestamo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter idLibro
     * @return el id del libro correspondiente al prestamo
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Setter idLibro
     * @param idLibro El parametro para modificar el id del libro correspondiente
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Getter idUsuario
     * @return el id del usuario que solicita el prestamo
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Setter idUsuario
     * @param idUsuario El parametro para modificar el id del usuario que solicita el prestamo
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Getter fechaPrestamo
     * @return la fecha de emision del prestamo
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Setter fechaPrestamo
     * @param fechaPrestamo El parametro para modificar la fecha de emision del prestamo
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Getter fechaDevolucion
     * @return la fecha de devolucion del libro
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Setter fechaDevolucion
     * @param fechaDevolucion El parametro para modificar la fecha de devolucion del libro
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Getter devuelto
     * @return el estado de devolucion del libro
     */
    public boolean isDevuelto() {
        return devuelto;
    }

    /**
     * Setter devuelto
     * @param devuelto El parametro para modificar el estado de devolucion del libro
     */
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}
