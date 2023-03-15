package lab8;

import java.util.Scanner;

public class Lab8a {
    public static void main(String[] args) {
        boolean active = true;
        while(active) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose from the following:");
            System.out.println("0. Quit");
            System.out.println("1. Multiply 2 numbers");
            System.out.println("2. Div 2 numbers");
            System.out.println("3. Mod 2 numbers");
            switch (input.nextLine()) { //input reader
                case "0" -> active = false;
                case "1" -> {
                    System.out.println("Enter first number");
                    int a = Integer.parseInt(input.nextLine());
                    System.out.println("Enter second number");
                    int b = Integer.parseInt(input.nextLine());
                    System.out.println("Answer: " + recursive_multiply(a, b));
                }
                case "2" -> {
                    System.out.println("Enter first number");
                    int n1 = Integer.parseInt(input.nextLine());
                    System.out.println("Enter second number");
                    int d1 = Integer.parseInt(input.nextLine());
                    System.out.println("Answer: " + recursive_div(n1, d1));
                }
                case "3" -> {
                    System.out.println("Enter first number");
                    int n2 = Integer.parseInt(input.nextLine());
                    System.out.println("Enter second number");
                    int d2 = Integer.parseInt(input.nextLine());
                    System.out.println("Answer: " + recursive_mod(n2, d2));
                }
            }
        }
    }

    public static int recursive_multiply(int a, int b) {
        if(b == 0) { //terminating condition
            return 0;
        }
        return a + recursive_multiply(a, b-1);
    }

    public static int recursive_div(int n, int d) {
        if(d == 0) { //terminating conditions
            return -1;
        }
        else if(n == d) {
            return 1;
        }
        else if(n < d) {
            return 0;
        }
        return 1 + recursive_div(n-d, d);
    }

    public static int recursive_mod(int n, int d) {
        if(d == 0) { //terminating conditions
            return -1;
        }
        else if(n < d) {
            return n;
        }
        return recursive_mod(n-d, d);
    }
}
