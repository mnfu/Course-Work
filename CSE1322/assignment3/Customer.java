package assignment3;

public abstract class Customer {
    private char letter;
    private int number;
    private static int nextA = 1; //next "customer" tracker
    private static int nextB = 1;
    private static int nextC = 1;
    private static int nextD = 1;

    public Customer() {
        letter = 'X';
        number = 0;
    }

    public Customer(char newLetter) {
        if(newLetter == 'A') {
            letter = newLetter;
            number = nextA;
            nextA++;
        }
        else if(newLetter == 'B') {
            letter = newLetter;
            number = nextB;
            nextB++;
        }
        else if(newLetter == 'C') {
            letter = newLetter;
            number = nextC;
            nextC++;
        }
        else if(newLetter == 'D') {
            letter = newLetter;
            number = nextD;
            nextD++;
        }
        else {
            letter = 'X';
            number = 0;
            System.out.println("Error, letter must be A, B, C or D");
        }
    }

    protected String getTicketNumber() {
        return letter+Integer.toString(number);
    }

    public abstract String getCustomerInfo(); //abstract method to make all children implement this method
}
