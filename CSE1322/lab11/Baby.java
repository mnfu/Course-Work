package lab11;

import java.util.Random;

public class Baby implements Runnable{
    int time;
    String name;

    public Baby(String newName){
        name = newName;
        Random random = new Random();
        time = random.nextInt(5000);
    }

    public void run(){
        try {
            System.out.println("My name is " + name + " I am going to sleep for " + time + "ms");
            Thread.sleep(time);
            System.out.println("My name is " + name + ", I am awake, feed me!!!");
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
