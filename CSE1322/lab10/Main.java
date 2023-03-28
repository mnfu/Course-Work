package lab10;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first file path:");
        String file1 = input.nextLine();
        System.out.println("Please enter the second file path:");
        String file2 = input.nextLine();
        compareFiles(file1, file2); //void method to compare the two input files for any differences
    }

    public static void compareFiles(String filepath1, String filepath2) {
        try {
            int lineNum = 1; //file(s) line number tracker
            String tempLine1;
            String tempLine2;
            File file1 = new File(filepath1);
            File file2 = new File(filepath2);
            Scanner scan1 = new Scanner(file1);
            Scanner scan2 = new Scanner(file2);
            while (scan1.hasNextLine() || scan2.hasNextLine()) { //if either of the files has a next line, it tries to compare them
                tempLine1 = scan1.nextLine();
                tempLine2 = scan2.nextLine();
                if(!tempLine1.equals(tempLine2)) {
                    System.out.println("Line " + lineNum);
                    System.out.println("< " + tempLine1);
                    System.out.println("> " + tempLine2);
                }
                lineNum++;
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (NoSuchElementException e) { //if the files have different lengths, "scan.nextLine()" will throw a NSE exception, which is caught to output the error message
            System.out.println("Files have different number of lines");
        }
    }
}
