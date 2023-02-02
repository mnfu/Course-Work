package lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Checking checking = new Checking();
        Savings savings = new Savings();

        while(true) {
            System.out.println("1. Withdraw from Checking");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Deposit to Checking");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Balance of Checking");
            System.out.println("6. Balance of Savings");
            System.out.println("7. Award Interest of Savings now");
            System.out.println("8. Quit");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            if(userInput.equals("1")) {
                System.out.println("How much would you like to withdraw from Checking?");
                checking.withdrawal(Double.parseDouble(input.nextLine()));
            }
            else if(userInput.equals("2")) {
                System.out.println("How much would you like to withdraw from Savings?");
                savings.withdrawal(Double.parseDouble(input.nextLine()));
            }
            else if(userInput.equals("3")) {
                System.out.println("How much would you like to deposit to Checking?");
                checking.deposit(Double.parseDouble(input.nextLine()));
            }
            else if(userInput.equals("4")) {
                System.out.println("How much would you like to deposit to Savings?");
                savings.deposit(Double.parseDouble(input.nextLine()));
            }
            else if(userInput.equals("5")) {
                System.out.println("Your balance for checking " + checking.getAccountNumber() + " is " + checking.getBalance());
            }
            else if(userInput.equals("6")) {
                System.out.println("Your balance for savings " + savings.getAccountNumber() + " is " + savings.getBalance());
            }
            else if(userInput.equals("7")) {
                savings.addInterest();
            }
            else if(userInput.equals("8")) {
                break;
            }
        }
    }
}

class Account {
    private static int accountNumberTracker = 10000;
    private final int accountNumber;
    private double Balance;

    public Account() {
        Balance = 0;
        accountNumber = accountNumberTracker += 1;
    }
    public Account(double startingBal) {
        Balance = startingBal;
        accountNumber = accountNumberTracker += 1;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return (double)Math.round(Balance*100)/100;
    }

    public void setBalance(double amount) {
        Balance = amount;
    }

    public void withdrawal(double amount) {
        Balance -= amount;
    }

    public void deposit(double amount) {
        Balance += amount;
    }

}

class Checking extends Account {
    public Checking() {
        super();
    }

    public Checking(double startingBal) {
        super(startingBal);
    }

    @Override
    public void withdrawal(double amount) {
        if(getBalance() - amount < 0) {
            System.out.println("Charging an overdraft fee of $20 because account is below $0");
            super.withdrawal(amount+20);
        }
        else {
            super.withdrawal(amount);
        }
    }
}

class Savings extends Account {
    private int depositNum = 1;
    public Savings() {
        super();
    }

    public Savings(double startingBal) {
        super(startingBal);
    }

    @Override
    public void withdrawal(double amount) {
        if(getBalance() - amount < 500) {
            System.out.println("Charging a fee of $10 because you are below $500");
            super.withdrawal(amount+10);
        }
        else {
            super.withdrawal(amount);
        }
    }
    @Override
    public void deposit(double amount) {
        System.out.println("This is deposit " + depositNum + " to this account");
        super.deposit(amount);
        if(depositNum>5) {
            System.out.println("Charging a fee of $10");
            super.withdrawal(10);
        }
        depositNum++;
    }

    public void addInterest() {
        double earnedInterest = getBalance()*0.015;
        System.out.println("Customer earned " + earnedInterest + " in interest");
        super.deposit(earnedInterest);
    }
}
