package assignment6;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean active = true;
        while(active) {
            Scanner input = new Scanner(System.in);
            System.out.println("One Bitcoin is currently worth $" + getDollarPrice(getData()));
            System.out.println("1. Buy Bitcoin");
            System.out.println("2. See everyones current value in USD");
            System.out.println("3. See one persons gain/loss");
            System.out.println("4. Quit");
            switch (input.nextLine()) {
                case "1" : buyBitCoin(getDollarPrice(getData()));
                    break;
                case "2" : getCurrentValue(getDollarPrice(getData()));
                    break;
                case "3" :
                    try {
                        System.out.println("Enter a name");
                        String name = input.nextLine();
                        float initial = getPersonFromFile(name, "C:\\Users\\BFTH0\\Documents\\Schoolwork\\CSE1322\\assignment6\\initialInvestmentUSD.txt");
                        float bitcoin = getPersonFromFile(name, "C:\\Users\\BFTH0\\Documents\\Schoolwork\\CSE1322\\assignment6\\clientBC.txt");
                        float currentvalue = bitcoin*getDollarPrice(getData());
                        System.out.println(name + ":");
                        System.out.println("Original Investment: $" + initial);
                        System.out.println("Number of bitcoins: " + bitcoin);
                        System.out.println("Current Value: $" + currentvalue);
                        System.out.println("Change in value: $" + (currentvalue-initial));
                    }
                    catch (PersonNotFound e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4" : active = false;
            }
        }
    }

    public static ArrayList<String> getData () {
        ArrayList<String> response = new ArrayList<>();
        try (Socket s = new Socket("api.coindesk.com", 80)) {
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
            pw.println("GET https://api.coindesk.com/v1/bpi/currentprice.json HTTP/1.0\n\n");
            pw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                response.add(tempLine);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return response;
    }

    public static float getDollarPrice(ArrayList<String> lines) { //given method for the assignment
        boolean header=true;
        String json="";
        for(String line : lines) {
            if(line.equals("")) {
                header=false;
                continue;
            }
            if(header==false) {
                json=line;
                break;
            }
        }
        String[] jsonParts=json.split(":");
        String priceLine=jsonParts[19];
        String justPrice=priceLine.replace("},\"GBP\"","");
        float price=Float.parseFloat(justPrice);
        return price;
    }

    public static void buyBitCoin(float price) {
        PrintWriter pw = null;
        try {
            String tempLine;
            File initial = new File("C:\\Users\\BFTH0\\Documents\\Schoolwork\\CSE1322\\assignment6\\initialInvestmentUSD.txt");
            Scanner scan = new Scanner(initial);
            File bitcoin = new File("C:\\Users\\BFTH0\\Documents\\Schoolwork\\CSE1322\\assignment6\\clientBC.txt");
            pw = new PrintWriter(bitcoin);
            while (scan.hasNextLine()) {
                tempLine = scan.nextLine();
                String[] data = tempLine.split(":");
                float bitcoins = Float.parseFloat(data[1])/price;
                pw.println(data[0] + ":" + bitcoins);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if (pw != null){
                pw.close();
            }
        }
    }

    public static void getCurrentValue(float price) {
        try {
            String tempLine;
            File initial = new File("C:\\Users\\BFTH0\\Documents\\Schoolwork\\CSE1322\\assignment6\\clientBC.txt");
            Scanner scan = new Scanner(initial);
            while (scan.hasNextLine()) {
                tempLine = scan.nextLine();
                String[] data = tempLine.split(":");
                float value = Float.parseFloat(data[1])*price;
                System.out.println(data[0]+":$" + value);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static float getPersonFromFile(String name, String fileName) throws PersonNotFound{
        try {
            String tempLine;
            File initial = new File(fileName);
            Scanner scan = new Scanner(initial);
            while (scan.hasNextLine()) {
                tempLine = scan.nextLine();
                String[] data = tempLine.split(":");
                if(data[0].equals(name)) {
                    return Float.parseFloat(data[1]);
                }
            }
            throw new PersonNotFound("Person was not found!");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}

class PersonNotFound extends Exception{
    public PersonNotFound(String message) {
        super(message);
    }
}
