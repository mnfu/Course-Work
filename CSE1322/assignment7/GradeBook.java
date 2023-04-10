package assignment7;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeBook {
    LinkedList<Student> studentLinkedList = new LinkedList<>();

    public GradeBook(String filePath) {
        try {
            File studentData = new File(filePath);
            Scanner fileScanner = new Scanner(studentData);
            while(fileScanner.hasNextLine()){
                studentLinkedList.add(new Student(fileScanner.nextLine()));
            }
        }
        catch (IOException ie) {
            System.out.println("Error reading in filepath: " + filePath);
        }
    }

    public Student getStudent(String name) {
        for(Student s : studentLinkedList){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    public void getStudentGrade(String name) {
        if(getStudent(name) == null){
            System.out.println("Student not found!");
            return;
        }
        System.out.println(getStudent(name).getGrade());
    }

    public LinkedList<String> getAllStudentNames() {
        LinkedList<String> studentNames = new LinkedList<>();
        for(Student s : studentLinkedList){
            studentNames.add(s.getName());
        }
        return studentNames;
    }
}
