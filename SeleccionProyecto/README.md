# Proyecto Seleccion

El proyecto seleccion es un ejercicio para revisar algunas convenciones de código según el *Google Java Style Guide*. El codigo implementa una clase abstracta `Personal` de la cual heredan las clases `Futbolista`, `Entrenador` y `Masajista`.

Presenta una estructura de código con las carpetas bin y src. En la carpeta source se encuentra el *package* `seleccion`.

## Reglas

En el código se documentan las siguientes reglas:

* **Regla 4.2 Block indentation**: +2 spaces: la identacion aumenta en 2 espacios cuando se abre un bloque de codigo, la identacion se devuelve al terminar el bloque:
```java
public abstract class Personal{
    ...
    public Personal(int identificador, String nombre, String apellido, int edad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
```
* **Regla 5.2.1 Package names**: el nombre de un paquete debe ser en minusculas, es decir, lowercase. El package de la clase de nombró como `seleccion`.
* **Regla 5.2.2 Class names**: el nombre de una clase debe utilizar notacion UpperCamelCase:
```java
public abstract class Personal{
    ...
}
```
* **Regla 5.2.3 Method names**: los metodos reciben nombe en lowerCamelCase:
```java
    public abstract void viajar();
```
* **Regla 6.1 @Override always used**: Siempre se utiliza la notacion @Override al sobrescribir metodos de una clase padre:
```java
    @Override
    public void concentrarse() {
        System.out.println("Concentrandose en juego...");
    }
```