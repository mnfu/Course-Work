package assignment3;

public class NewTest extends Customer {
    private String name;
    private String dateOfBirth;

    public NewTest(String newName, String newDateOfBirth) {
        super('A');
        name = newName;
        dateOfBirth = newDateOfBirth;
    }

    @Override
    public String getCustomerInfo() { //required method because of the abstract getCustomerInfo() in Customer
        return "New Drivers License. Ticket Number: " + getTicketNumber() + ". Name: " + name + " DOB: " + dateOfBirth;
    }
}
