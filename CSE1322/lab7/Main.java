package lab7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean active = true;
        while(active) {
            Calculator calculator = new Calculator();
            Scanner input = new Scanner(System.in);
            System.out.println("\n0 - Exit\n1 - Addition\n2 - Subtraction\n3 - Multiplication\n4 - Division");
            System.out.print("Please choose an Option: ");
            int option = Integer.parseInt(input.nextLine());
            if(option == 0) {
                active = false;
            }
            else {
                System.out.print("Please enter the first number: ");
                float n1 = Float.parseFloat(input.nextLine());
                System.out.print("Please enter the second number: ");
                float n2 = Float.parseFloat(input.nextLine());
                switch (option) {
                    case 1 -> System.out.println(calculator.add(n1, n2));
                    case 2 -> System.out.println(calculator.subtract(n1, n2));
                    case 3 -> System.out.println(calculator.multiply(n1, n2));
                    case 4 -> System.out.println(calculator.divide(n1, n2));
                }
            }
        }
    }
}