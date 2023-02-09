package lab5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Item[] Items = new Item[5];

        for(int i = 0; i < 5; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter B for Book or P for Periodical");
            String userInput = input.nextLine();
            if(userInput.equals("B")) {
                System.out.println("Please enter the name of the Book");
                String title = input.nextLine();
                System.out.println("Please enter the author of the Book");
                String author = input.nextLine();
                System.out.println("Please enter the ISBN of the Book");
                String isbn = input.nextLine();
                Items[i] = new Book(title,Integer.parseInt(isbn),author);
            }
            else if(userInput.equals("P")) {
                System.out.println("Please enter the name of the Periodical");
                String title = input.nextLine();
                System.out.println("Please enter the issue number");
                String issNum = input.nextLine();
                Items[i] = new Periodical(title,Integer.parseInt(issNum));
            }
        }
        System.out.println("Your Items:");
        for (Item item : Items) {
            System.out.println(item.getListing() + "\n");
        }
    }
}

abstract class Item {
    private String title;

    public Item() {
        title = "";
    }

    public Item(String newTitle) {
        title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public abstract String getListing();

    @Override
    public String toString() {
        return title;
    }
}

class Book extends Item {
    private int isbn_number;
    private String author;

    public Book() {
        super();
        isbn_number = 0;
        author = "";
    }

    public Book(String bookTitle, int isbn_num, String bookAuthor) {
        super(bookTitle);
        isbn_number = isbn_num;
        author = bookAuthor;
    }

    public int getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(int isbn_num) {
        isbn_number = isbn_num;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String bookAuthor) {
        author = bookAuthor;
    }

    @Override
    public String getListing() {
        return "Book Name - " + getTitle() + "\nAuthor - " + getAuthor() + "\nISBN# - " + getIsbn_number();
    }
}

class Periodical extends Item {
    private int issueNum;

    public Periodical() {
        super();
        issueNum = 0;
    }

    public Periodical(String periodicalTitle, int periodicalIssueNum) {
        super(periodicalTitle);
        issueNum = periodicalIssueNum;
    }

    public int getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(int periodicalIssueNum) {
        issueNum = periodicalIssueNum;
    }

    @Override
    public String getListing() {
        return "Periodical Title - " + getTitle() + "\nIssue # - " + getIssueNum();
    }
}
