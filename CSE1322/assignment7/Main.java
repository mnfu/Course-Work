package assignment7;

public class Main {
    public static void main(String[] args) {
        //Student s = new Student("Rob,20140,10,20,30,40,50,60,70,80,90,100,10,20,30,40,50,60,70,80,90,100,200,200"); //all stuff here currently is debug code
        Student s = new Student("Rob,20140,100,100,100,100,100,100,100,100,100,100,10,20,30,40,50,60,70,80,90,100,200,200");
        s.calcQuizAverage();
        s.calcHomeworkAverage();
        s.calcOverallAverage();
        System.out.println(s.getGrade());
    }
}
