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
                    System.out.println("What is your name?");
                    String tName = input.nextLine();
                    System.out.println("What is your date of birth?");
                    String tDob = input.nextLine();
                    Customer newTest = new NewTest(tName, tDob); //create a customer of type NewTest to add to the Customer arraylist
                    customerQueue.add(newTest);
                    break;
                case 2:
                    System.out.println("What is your name?");
                    String rName = input.nextLine();
                    Customer renew = new Renew(rName);
                    customerQueue.add(renew);
                    break;
                case 3:
                    System.out.println("What is your name?");
                    String mName = input.nextLine();
                    System.out.println("What state did you move from?");
                    String state = input.nextLine();
                    Customer move = new Move(mName, state);
                    customerQueue.add(move);
                    break;
                case 4:
                    System.out.println("What is your name?");
                    String sName = input.nextLine();
                    System.out.println("What violation did you commit?");
                    String violation = input.nextLine();
                    Customer suspended = new Suspended(sName, violation);
                    customerQueue.add(suspended);
                    break;
                case 5:
                    for(Customer i : customerQueue) {
                        System.out.println(i.getCustomerInfo());
                    }
                    break;
                case 6:
                    active = false; //stop the while loop
                    break;
            }
        }
    }
}
