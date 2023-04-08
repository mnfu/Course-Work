package assignment7;

public class Student {
    private int[] quizScores = new int[10];
    private int[] homeworkScores = new int[10];
    private int midTermGrade = 0;
    private int finalExamGrade = 0;
    private double quizAverage = 0.0;
    private double homeworkAverage = 0.0;
    private double overallAverage = 0.0;
    private String name = "";
    private int id = 0;

    public Student(String str){
        try {
            String[] data = str.split(",");
            name = data[0];
            id = Integer.parseInt(data[1]);
            for(int i = 0; i < 22; i++){
                if(Integer.parseInt(data[i+2]) < 0) { //can't have a negative grade
                    data[i+2] = "0";
                }
                else if (Integer.parseInt(data[i+2]) > 100) { //^ or above 100
                    data[i+2] = "100";
                }
            }
            for(int i = 0; i < 10; i++){
                quizScores[i] = Integer.parseInt(data[i+2]); //data array 2-11
            }
            for(int i = 0; i < 10; i++){
                homeworkScores[i] = Integer.parseInt(data[i+12]); //data array 12-21
            }
            midTermGrade = Integer.parseInt(data[22]);
            finalExamGrade = Integer.parseInt(data[23]);
        }
        catch (NumberFormatException nfe) {
            System.out.println("Error reading in student: " + name + "'s data");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: student: " + name + " is missing data");
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void calcQuizAverage() {
        int temp = 100;
        int total = 0;
        for(int i = 0; i < 10; i++) {
            if(quizScores[i] < temp) {
                temp = quizScores[i];
            }
            total += quizScores[i];
        }
        total -= temp; //removes lowest grade
        quizAverage = total / 9.0;
    }

    public void calcHomeworkAverage() {
        int temp = 100;
        int total = 0;
        for(int i = 0; i < 10; i++) {
            if(homeworkScores[i] < temp) { //sees if current score is less than temp
                temp = homeworkScores[i];
            }
            total += homeworkScores[i];
        }
        total -= temp; //removes lowest grade
        homeworkAverage = total / 9.0;
    }

    public void calcOverallAverage() {
        overallAverage = (quizAverage*0.4 + homeworkAverage*0.1 + midTermGrade*0.2 + finalExamGrade*0.3);
    }

    public String getGrade() { //returns a grade report as a string
        String grade = "";
        for(int i = 0; i < 10; i++) {
            grade += "Quiz " + i + ": " + quizScores[i] + "\n";
        }
        grade += "Quiz Avg: " + quizAverage + "\n";
        for(int i = 0; i < 10; i++) {
            grade += "Quiz " + i + ": " + homeworkScores[i] + "\n";
        }
        grade += "HW Avg: " + homeworkAverage + "\n";
        grade += "Midterm: " + midTermGrade + "\n";
        grade += "Final Exam: " + finalExamGrade + "\n";
        grade += "Overall Average: " + overallAverage;
        return grade;
    }
}