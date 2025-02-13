/* Regla 5.2.1 Package names
 * El nombre de un paquete debe ser en minusculas, es decir, lowercase
 */
package seleccion;
/* Regla 5.2.2 Class names
 * El nombre de una clase debe utilizar notacion UpperCamelCase
*/
public abstract class Personal {
    private int identificador;
    private String nombre;
    private String apellido;
    private int edad;

    /* Regla 4.2 Block indentation: +2 spaces
     * La identacion aumenta en 2 espacios cuando se abre un bloque de codigo, la
     * identacion se devuelve al terminar el bloque
    */
    public Personal(int identificador, String nombre, String apellido, int edad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    /* Regla 5.2.3 Method names
     * Los metodos reciben nombe en lowerCamelCase
    */
    public abstract void viajar();

    public abstract void concentrarse();
}
