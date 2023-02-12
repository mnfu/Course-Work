package assignment3;

public class Suspended extends Customer {
    private String name;
    private String violation; //what they are in trouble for

    public Suspended(String newName, String newViolation) {
        super('D');
        name = newName;
        violation = newViolation;
    }

    @Override
    public String getCustomerInfo() { //required method because of the abstract getCustomerInfo() in Customer
        return "Violation: " + violation + ". Ticket Number: " + getTicketNumber() + ". Name: " + name;
    }
}
