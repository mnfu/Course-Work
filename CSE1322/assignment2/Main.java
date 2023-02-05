package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Lot> auction = new ArrayList<Lot>();
        mainMenu(auction);
    }

    public static Lot getNextLot(ArrayList<Lot> auction) { //removes the sold lot from the auction list, and brings the new one forward
        if(auction.size() > 0) {
            Lot nextLot = auction.get(0);
            auction.remove(0);
            return nextLot;
        }
        else {
            return new Lot();
        }
    }

    public static void addItem(ArrayList<Lot> auction) { //prompts the user for item information, then adds item to auction
        Scanner input = new Scanner(System.in);
        System.out.println("What is the description of this item");
        String desc = input.nextLine();
        System.out.println("What is the starting bid");
        String startBid = input.nextLine();
        System.out.println("What is the bid increment");
        String bidInc = input.nextLine();
        auction.add(new Lot(desc, Integer.parseInt(startBid), Integer.parseInt(bidInc)));
    }

    public static void bid(Lot currentLot) { //asks how much the bid is, and tells minimum bid. then checks if bid is less than minimum bid, tells user such if true
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
        Lot currentLot = null;
        boolean active = true;
        while(active) { //create a while loop for the main menu
            Scanner input = new Scanner(System.in);
            if(currentLot == null || currentLot.getDescription().equals("Unknown Item")) { //checks if cL is null, or if cL desc is "UI"
                System.out.println("We are not currently bidding");
            }
            else {
                System.out.println("Current Lot:");
                System.out.println(currentLot);
            }
            System.out.println("\n1. Add Lot to Auction");
            System.out.println("2. Start bidding on next Lot");
            System.out.println("3. Bid on current Lot");
            System.out.println("4. Mark current Lot sold");
            System.out.println("5. Quit");
            switch(input.nextLine()) { //switch cases for different user inputs
                case "1":
                    addItem(auction);
                    break;
                case "2":
                    if(auction.size() == 0) { //checks if auction list is empty
                        System.out.println("There is nothing to bid on, add an item first");
                    }
                    else if((currentLot != null && !currentLot.getDescription().equals("Unknown Item")) && !currentLot.getSold() ) { //checks if cL isn't null, if cL desc isn't "UI", & if cL isn't sold
                        System.out.println("You must mark the current lot as sold before bringing up the next Lot");
                    }
                    else {
                        currentLot = getNextLot(auction);
                    }
                    break;
                case "3":
                    if(currentLot == null || currentLot.getDescription().equals("Unknown Item") || currentLot.getSold()) { //checks if cL is null, or if cL desc is "UI", or if cL is sold
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else {
                        bid(currentLot);
                    }
                    break;
                case "4":
                    if(currentLot == null || currentLot.getDescription().equals("Unknown Item") || currentLot.getSold()) { //checks if cL is null, or if CL desc is "UI", or if cL is sold
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else {
                        markSold(currentLot);
                    }
                    break;
                case "5":
                    active = false;
                    break;
            }
        }
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
            return "Lot " + lotNumber + ". " + getDescription() + " current bid $" + currentBid + " minimum bid $" + nextBid();
        }
    }
}