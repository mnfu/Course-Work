package lab9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            int time1 = findSeconds(input.nextLine());
            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            int time2 = findSeconds(input.nextLine());
            if(time1 > time2) {
                System.out.println("Difference in seconds: " + (time1 - time2));
            }
            else {
                System.out.println("Difference in seconds: " + (time2 - time1));
            }
        }
        catch (InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findSeconds(String str) throws InvalidTimeException {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String[] nums = str.split(":");
        if(nums.length != 3) {
            throw new InvalidTimeException("Enter a valid time");
        }
        try {
            hours = Integer.parseInt(nums[0]);
            minutes = Integer.parseInt(nums[1]);
            seconds = Integer.parseInt(nums[2]);
        }
        catch (NumberFormatException e) {
            throw new InvalidTimeException("Enter a valid time");
        }
        if(hours > 23 || hours < 0) {
            throw new InvalidTimeException("Hour must be below 24");
        }
        if(minutes > 59 || minutes < 0) {
            throw new InvalidTimeException("Minutes must be less than 60");
        }
        if(seconds > 59 || seconds < 0) {
            throw new InvalidTimeException("Seconds must be less than 60");
        }

        return (hours*60*60) + (minutes*60) + seconds;
    }
}

class InvalidTimeException extends Exception{
    public InvalidTimeException(String message) {
        super(message);
    }
}
