import FizzBuzz.*;

public class App {
    public static void main(String[] args) throws Exception {

        ConsoleBasedFizzBuzzRefactor console = new ConsoleBasedFizzBuzzRefactor();
        // Refactor Extract method:  Se reemplazo la solicitud del valor maximo desde consola en un metodo
        // Refactor Replace Parameter with Method Call: El metodo para solicitar valor maximo se incluyo desde el metodo printFizzBuzzTest
        console.printFizzBuzzTest(1);

        console.closeScanner();
    }
}
