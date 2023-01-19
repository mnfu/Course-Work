package lab2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean keepOn = true;
        StockItem milk = new StockItem("1 Gallon of Milk", 3.60, 15);
        StockItem bread = new StockItem("1 Loaf of Bread", 1.98, 30);
        while(keepOn) {
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
            if (userInput.equals("1")) {
                milk.removeQuantity(1);
            }
            else if (userInput.equals("2")) {
                bread.removeQuantity(1);
            }
            else if (userInput.equals("3")) {
                System.out.println("What is the new price for Milk?");
                String newPrice = input.nextLine();
                milk.setPrice(Double.parseDouble(newPrice));
            }
            else if (userInput.equals("4")) {
                System.out.println("What is the new price for Bread?");
                String newPrice = input.nextLine();
                bread.setPrice(Double.parseDouble(newPrice));
            }
            else if (userInput.equals("5")) {
                System.out.println("How many Milk did we get?");
                String newQuantity = input.nextLine();
                milk.addQuantity(Integer.parseInt(newQuantity));
            }
            else if (userInput.equals("6")) {
                System.out.println("How many Bread did we get?");
                String newQuantity = input.nextLine();
                bread.addQuantity(Integer.parseInt(newQuantity));
            }
            else if (userInput.equals("7")) {
                System.out.println(milk);
                System.out.println(bread);
            }
            else if (userInput.equals("8")) {
                keepOn = false;
            }
            else {
                System.out.println("Not a valid item, please try again!");
            }
        }
    }
}
class StockItem {
    private String description = "";
    private int id = 0;
    private double price = 0.0;
    private int quantity = 0;
    private static int itemID = 0;

    public StockItem() {
        this.description = "no description provided";
        this.id = itemID += 1;
        this.price = 0.00;
        this.quantity = 1;
    }
    public StockItem(String description, double price, int quantity) {
        this.description = description;
        this.id = itemID += 1;
        this.price = (int)(price*100+0.5)/(100d);
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        if(price > 0) {
            this.price = (int)(price*100+0.5)/(100d);
        }
        else {
            System.out.println("ERROR: PRICE CANNOT BE LESS THAN $0.00");
        }
    }
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    public void removeQuantity(int quantity) {
        if(this.quantity - quantity > 0) {
            this.quantity -= quantity;
        }
    }
    public String getDescription() {
        return this.description;
    }
    public int getId() {
        return this.id;
    }
    public double getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
    @Override
    public String toString() {
        return "Item number: " + id + " is " + description + ", has a price of: $" + price + " and we currently have: " + quantity + " in stock";
    }
}
