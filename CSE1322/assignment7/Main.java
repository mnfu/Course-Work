package assignment7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StatisticGradeBook grader = new StatisticGradeBook("C:\\Users\\BFTH0\\Documents\\Schoolwork\\CSE1322\\assignment7\\Assignment7-Spreadsheet.csv");
        Thread t1 = new Thread(grader);
        t1.start();
        System.out.println("What student would you like to see grades for");
        Scanner input = new Scanner(System.in);
        grader.getStudentGrade(input.nextLine());
    }
}
