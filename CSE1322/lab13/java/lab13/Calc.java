package lab13;

public class Calc {
    public static String add(String num1, String num2){
        try{
            return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
        }
        catch (NumberFormatException e) {
            return "Please enter two integers.";
        }
    }
}
