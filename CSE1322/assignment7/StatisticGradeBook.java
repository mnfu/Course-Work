package assignment7;

import java.util.LinkedList;

public class StatisticGradeBook extends GradeBook implements Runnable{
    public StatisticGradeBook(String filePath) {
        super(filePath);
    }

    public void run() {
        LinkedList<String> studentNames = super.getAllStudentNames();
        int totalStudents = studentNames.size();
        int totalProcessed = 0;
        for(Student s : studentLinkedList){
            s.calcQuizAverage();
            s.calcHomeworkAverage();
            s.calcOverallAverage();
            System.out.println("Calculating grades " + totalProcessed + " out of " + totalStudents);
            totalProcessed++;
        }
        System.out.println("All grades calculated");
    }
}
