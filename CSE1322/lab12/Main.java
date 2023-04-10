package lab12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BlueRayCollection collection = new BlueRayCollection();
        boolean active = true;
        while(active){
            Scanner input = new Scanner(System.in);
            System.out.println("\n0. Quit");
            System.out.println("1. Add BlueRay to collection");
            System.out.println("2. See collection");
            try{
                switch (input.nextLine()) {
                    case "0" :
                        active = false;
                        break;
                    case "1" :
                        System.out.println("What is the title?");
                        String title = input.nextLine();
                        System.out.println("What is the director?");
                        String director = input.nextLine();
                        System.out.println("What is the year of release?");
                        int yearOfRelease = Integer.parseInt(input.nextLine());
                        System.out.println("What is the cost?");
                        double cost = Double.parseDouble(input.nextLine());
                        collection.add(title, director, yearOfRelease, cost);
                        break;
                    case "2" :
                        collection.show_all();
                        break;
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println("Error " + nfe.getMessage());
            }
        }
    }
}
