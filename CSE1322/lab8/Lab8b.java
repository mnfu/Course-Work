package lab8;

import java.util.Scanner;

public class Lab8b {
    public static void main(String[] args) {
        System.out.println(repeatNTimes("I must study recursion until it makes sense\n", 100));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str1 = input.nextLine();
        System.out.println("Enter the second string");
        String str2 = input.nextLine();
        if(isReverse(str1, str2)) {
            System.out.println(str1 + " is the reverse of " + str2);
        }
        else {
            System.out.println(str1 + " is not the reverse of " + str2);
        }
    }

    public static String repeatNTimes(String str, int n) {
        if(n == 1) { //main terminating condition
            return str;
        }
        else if(n == 0) { //special case terminating condition
            return "";
        }
        return str + repeatNTimes(str, n-1);
    }

    public static boolean isReverse(String str1, String str2) {
        if(str1.length() == 0 && str2.length() == 0) { //main terminating condition
            return true;
        }
        else if(str1.charAt(0) != str2.charAt(str2.length()-1)) {
            return false;
        }
        return isReverse(str1.substring(1), str2.substring(0, str2.length()-1));
    }
}
