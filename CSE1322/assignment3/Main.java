package assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> queue = new ArrayList<>();
        menu(queue);
    }

    public static void menu(ArrayList<Customer> customerQueue) {
        boolean active = true;
        while(active) {
            System.out.println("1. Take test for new license");
            System.out.println("2. Renew existing license");
            System.out.println("3. Move from out of state");
            System.out.println("4. Answer citation/suspended license");
            System.out.println("5. See current queue");
            System.out.println("6. Quit");
            Scanner input = new Scanner(System.in);
            int userInput = Integer.parseInt(input.nextLine());
            switch(userInput) { //switch cases for different user inputs
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    active = false;
                    break;
            }
        }
    }
}
