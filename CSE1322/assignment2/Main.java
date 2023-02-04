package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Lot> auction = new ArrayList<Lot>();
        mainMenu(auction);
    }
    public static Lot getNextLot(ArrayList<Lot> auction) {
        if(auction.size() > 0) {
            Lot nextLot = auction.get(0);
            auction.remove(0);
            return nextLot;
        }
        else {
            return new Lot();
        }
    }

    public static void addItem(ArrayList<Lot> auction) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the description of this item");
        String desc = input.nextLine();
        System.out.println("What is the starting bid");
        String startBid = input.nextLine();
        System.out.println("What is the bid increment");
        String bidInc = input.nextLine();
        auction.add(new Lot(desc, Integer.parseInt(startBid), Integer.parseInt(bidInc)));
    }

    public static void bid(Lot currentLot) {
        Scanner input = new Scanner(System.in);
        System.out.println("How much would you like to bid?");
        System.out.println("Minimum bid is " + currentLot.nextBid());
        String userBid = input.nextLine();
        if(Integer.parseInt(userBid) < currentLot.nextBid()) {
            System.out.println("You must bid at least " + currentLot.nextBid());
        }
        else {
            currentLot.setCurrentBid(Integer.parseInt(userBid));
        }
    }

    public static void markSold(Lot currentLot) {
        currentLot.markSold();
        System.out.println(currentLot);
    }

    public static void mainMenu(ArrayList<Lot> auction) {
        System.out.println("MENU SYSTEM"); //Add menu system later to make the auction functional
    }



}

class Lot {
    private int lotNumber;
    private String description;
    private int currentBid;
    private int bidIncrement;
    private boolean sold;
    private static int lotNumberTracker = 1000; //tracks the numbers across all lots

    public Lot() {
        lotNumber = lotNumberTracker + 1;
        description = "Unknown Item";
        currentBid = 0;
        bidIncrement = 0;
        sold = false;
    }

    public Lot(String Desc, int startingBid, int bidInc) {
        lotNumber = lotNumberTracker + 1;
        description = Desc;
        currentBid = startingBid;
        bidIncrement = bidInc;
        sold = false;
    }

    public void markSold() {
        sold = true;
    }

    public boolean getSold() { //getter methods
        return sold;
    }

    public int getBidIncrement() {
        return bidIncrement;
    }

    public String getDescription() {
        return description;
    }

    public void setCurrentBid(int newBid) { //setter method for a new bid coming in
        currentBid = newBid;
    }

    public int nextBid() {
        return currentBid + getBidIncrement();
    }

    @Override
    public String toString() { //override the toString for a custom output
        if(getSold()) {
            return "Lot " + lotNumber + ". " + getDescription() + " was sold for $" + currentBid;
        }
        else {
            return "Lot " + lotNumber + ". " + getDescription() + "current bid $" + currentBid + " minimum bid $" + nextBid();
        }
    }
}