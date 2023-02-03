package assignment2;

public class Main {
    public static void main(String[] args) {
        //write methods here for the program to run correctly later
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