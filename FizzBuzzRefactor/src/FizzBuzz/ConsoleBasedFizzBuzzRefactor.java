package FizzBuzz;

import java.util.Scanner;

public class ConsoleBasedFizzBuzzRefactor implements FizzBuzz{
    
    final private Scanner input = new Scanner(System.in);

    public ConsoleBasedFizzBuzzRefactor() {
    }

    @Override
    public void printFizzBuzzTest(int from) {
        int to = askMax();

        for (int i = from; i <= to; i++){
            if (i % 15 == 0)
                System.out.println("FizzBuzz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else
                System.out.println(i);
        }
    }

    // Refactor Hide Method: El metodo para solicitar valor maximo se declaro como privado
    private int askMax(){
        System.out.print("Ingresa el maximo: ");
        return Integer.parseInt(input.nextLine());
    }

    public void closeScanner(){
        input.close();
    }
}
