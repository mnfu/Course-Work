package assignment3;

public class Move extends Customer {
    private String name;
    private String state; //what state they moved from

    public Move(String newName, String oldState) {
        super('C');
        name = newName;
        state = oldState;
    }

    @Override
    public String getCustomerInfo() { //required method because of the abstract getCustomerInfo() in Customer
        return "Moved from " + state + ". Ticket Number: " + getTicketNumber() + ". Name: " + name;
    }
}
