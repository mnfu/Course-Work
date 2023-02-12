package assignment3;

public class Renew extends Customer {
    private String name;

    public Renew(String newName) {
        super('B');
        name = newName;
    }

    @Override
    public String getCustomerInfo() { //required method because of the abstract getCustomerInfo() in Customer
        return "Renewal License. Ticket Number: " + getTicketNumber() + ". Name: " + name;
    }
}
