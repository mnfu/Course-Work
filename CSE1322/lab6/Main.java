package lab6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FibIteration Iterate = new FibIteration();
        FibFormula Formula = new FibFormula();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number you want to find the Fibonacci Series for:");
        String number = input.nextLine();
        int num = Integer.parseInt(number);
        System.out.println("Fib of " + num + " by iteration is: " + Iterate.calculate_fib(num));
        System.out.println("Fib of " + num + " by formula is: " + Formula.calculate_fib(num));
    }
}
