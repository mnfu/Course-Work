package lab2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StockItem milk = new StockItem("1 Gallon of Milk", 3.60, 15);
        StockItem bread = new StockItem("1 Loaf of Bread", 1.98, 30);
        while(true) { //create a menu for the "shopkeeper" to interact with, and do something with their response
            System.out.println("\n1. Sold One Milk");
            System.out.println("2. Sold One Bread");
            System.out.println("3. Change price of Milk");
            System.out.println("4. Change price of Bread");
            System.out.println("5. Add Milk to Inventory");
            System.out.println("6. Add Bread to Inventory");
            System.out.println("7. See Inventory");
            System.out.println("8. Quit");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            if (userInput.equals("1")) { //"sold an item" options
                milk.removeQuantity(1);
            }
            else if (userInput.equals("2")) {
                bread.removeQuantity(1);
            }
            else if (userInput.equals("3")) {
                System.out.println("What is the new price for Milk?"); //set price options
                String newPrice = input.nextLine();
                milk.setPrice(Double.parseDouble(newPrice));
            }
            else if (userInput.equals("4")) {
                System.out.println("What is the new price for Bread?");
                String newPrice = input.nextLine();
                bread.setPrice(Double.parseDouble(newPrice));
            }
            else if (userInput.equals("5")) {
                System.out.println("How many Milk did we get?"); //set quantity options
                String newQuantity = input.nextLine();
                milk.addQuantity(Integer.parseInt(newQuantity));
            }
            else if (userInput.equals("6")) {
                System.out.println("How many Bread did we get?");
                String newQuantity = input.nextLine();
                bread.addQuantity(Integer.parseInt(newQuantity));
            }
            else if (userInput.equals("7")) { //inventory printer
                System.out.println(milk);
                System.out.println(bread);
            }
            else if (userInput.equals("8")) {
                break;
            }
            else {
                System.out.println("Not a valid item, please try again!");
            }
        }
    }
}
class StockItem {
    private String description;
    private int id;
    private double price;
    private int quantity;
    private static int itemID = 0;

    public StockItem() { //default constructor
        description = "no description provided";
        id = itemID += 1;
        price = 0.00;
        quantity = 1;
    }
    public StockItem(String Description, double Price, int Quantity) {
        description = Description;
        id = itemID += 1;
        price = (int)(Price*100+0.5)/(100d);
        quantity = Quantity;
    }
    public void setPrice(double Price) {
        if(Price > 0) {
            price = (int)(Price*100+0.5)/(100d);
        }
        else {
            System.out.println("ERROR: PRICE CANNOT BE LESS THAN $0.00");
        }
    }
    public void addQuantity(int Quantity) {
        quantity += Quantity;
    }
    public void removeQuantity(int Quantity) {
        if(quantity - Quantity >= 0) {
            quantity -= Quantity;
        }
        else {
            System.out.println("ERROR: QUANTITY CANNOT BE LESS THAN 0");
        }
    }
    public String getDescription() {
        return description;
    }
    public int getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String toString() { //an override toString for the assignment requirements
        return "Item number: " + getId() + " is " + getDescription() + ", has a price of: $" + getPrice() + " and we currently have: " + getQuantity() + " in stock";
    }
}
