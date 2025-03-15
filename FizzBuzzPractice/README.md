# Refactorización

Con base en el problema FuzzBuzz realizado en actividad anterior; mejora el código sin cambiar la funcionalidad, aplicando al menos 4 técnicas de refactorización, con base en el material pulicado en el sitio web "Refactoring Techniques" (https://refactoring.guru/refactoring/techniques).

Entrega:

1. Subir el código fuente antes de refactorizar
2. Subir código fuente después de refactorizar

## Cambios

### Refactor Rename Method: Se renombro el método por un nombre mas descriptivo

Antes:
```java    
void print(int from, int to);  
```

Después:

```java    
void printFizzBuzzTest(int from, int to);
```

### Refactor Extract method:  Se reemplazo la solicitud del valor maximo desde consola en un metodo

Antes:
```java  
Scanner input = new Scanner(System.in);

System.out.print("Proporciona el limite maximo: ");
int to = Integer.parseInt(input.nextLine());

consolaFizz.print(1, to);
```

Después:
```java 
public int askMax(){
        System.out.print("Ingresa el maximo: ");
        return Integer.parseInt(input.nextLine());
    }
// ...
int to = askMax();
consolaFizz.printFizzBuzzTest(1, to);
```
### Refactor Replace Parameter with Method Call: El metodo para solicitar valor maximo se incluyo dentro del metodo printFizzBuzzTest
Antes:
```java
consolaFizz.printFizzBuzzTest(1, to);
```
Despues:
```java
public class ConsoleBasedFizzBuzzRefactor implements FizzBuzz{
    // ...
    public int askMax() {
        System.out.print("Ingresa el maximo: ");
        return Integer.parseInt(input.nextLine());
    }
    // ...
}
// ...
public static void main(String[] args) throws Exception {

        ConsoleBasedFizzBuzzRefactor console = new ConsoleBasedFizzBuzzRefactor();
        
        console.printFizzBuzzTest(1);
}
```

### Refactor Hide Method: El metodo para solicitar valor maximo se declaro como privado
Antes:
```java
public class ConsoleBasedFizzBuzzRefactor implements FizzBuzz{
    // ...
    public int askMax() {
        System.out.print("Ingresa el maximo: ");
        return Integer.parseInt(input.nextLine());
    }
    // ...
}
// ...
```

Después:
```java
public class ConsoleBasedFizzBuzzRefactor implements FizzBuzz{
    // ...
    private int askMax() {
        System.out.print("Ingresa el maximo: ");
        return Integer.parseInt(input.nextLine());
    }
    // ...
}
```