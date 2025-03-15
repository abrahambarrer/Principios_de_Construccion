import java.util.Scanner;

import FizzBuzz.*;

public class App {
    public static void main(String[] args) throws Exception {
        ConsoleBasedFizzBuzz consolaFizz = new ConsoleBasedFizzBuzz();
        Scanner input = new Scanner(System.in);

        System.out.print("Proporciona el limite maximo: ");
        int to = Integer.parseInt(input.nextLine());

        // Replace Parameter with Method Call
        consolaFizz.print(1, to);

        input.close();
    }
}