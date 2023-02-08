package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        while(true) { //create a quiz menu & response reader
            System.out.println("What would you like to do?");
            System.out.println("1. Add a question to the quiz");
            System.out.println("2. Remove a question from the quiz");
            System.out.println("3. Modify a question in the quiz");
            System.out.println("4. Take the quiz");
            System.out.println("5. Quit");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            if (userInput.equals("1")) {
                quiz.addQuestion();
            }
            else if (userInput.equals("2")) {
                quiz.removeQuestion();
            }
            else if (userInput.equals("3")) {
                quiz.modifyQuestion();
            }
            else if (userInput.equals("4")) {
                quiz.giveQuiz();
            }
            else if (userInput.equals("5")) {
                break;
            }
        }
    }
}

class Question {
    private String question;
    private String answer;
    private int difficulty;

    public Question(String q, String a, int d) { //question constructor
        question = q;
        answer = a;
        difficulty = d;
    }

    public void setQuestion(String q) {
        question=q;
    }

    public void setAnswer(String a) {
        answer=a;
    }

    public void setDifficulty(int d) {
        difficulty=d;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getDifficulty() {
        return difficulty;
    } //unused, but required via lab instructions
}

class Quiz {
    ArrayList<Question> Quiz = new ArrayList<Question>();
    Scanner input = new Scanner(System.in);
    public void addQuestion() {
        System.out.println("What is the question text?");
        String qQuestion = input.nextLine();
        System.out.println("What is the answer?");
        String qAnswer = input.nextLine();
        System.out.println("How Difficult (1-3)?");
        int qDifficulty = Integer.parseInt(input.nextLine());
        if((qDifficulty < 1) || (qDifficulty > 3)) { //checks to make sure the difficulty isn't anything beyond 1-3
            System.out.println("ERROR, NOT 1-3. QUESTION CREATION FAILED"); //completely scraps the question creation
        }
        else {
            Question newQ = new Question(qQuestion, qAnswer, qDifficulty);
            Quiz.add(newQ);
        }
    }

    public void removeQuestion() {
        System.out.println("Choose the question to remove?");
        int num = 0;
        for(Question q : Quiz) { //prints out all questions with identifiers
            System.out.println(num + ". " + q.getQuestion());
            num++;
        }
        Quiz.remove(Integer.parseInt(input.nextLine())); //removes the question ID chosen
    }

    public void modifyQuestion() {
        System.out.println("Choose the question to modify?");
        int num = 0;
        for(Question q : Quiz) {
            System.out.println(num + ". " + q.getQuestion());
            num++;
        }
        int qNum = (Integer.parseInt(input.nextLine()));
        while(qNum >= Quiz.size() || qNum < 0) { //makes sure user only selects values within the quizzes bounds
            System.out.println("ERROR: NOT A VALID QUESTION, please try again!");
            qNum = (Integer.parseInt(input.nextLine()));
        }
        System.out.println("What is the question text?");
        Quiz.get(qNum).setQuestion(input.nextLine());
        System.out.println("What is the answer?");
        Quiz.get(qNum).setAnswer(input.nextLine());
        System.out.println("How Difficult (1-3)?");
        int qDifficulty = Integer.parseInt(input.nextLine());
        if((qDifficulty != 1) && (qDifficulty != 2) && (qDifficulty != 3)) {
            System.out.println("ERROR, NOT 1-3. QUESTION DIFFICULTY WAS NOT CHANGED"); //question is still modified, but the difficulty was not changed
        }
        else {
            Quiz.get(qNum).setDifficulty(qDifficulty);
        }
    }

    public void giveQuiz() {
        int score = 0; //tracker of correct answers
        for(Question q : Quiz) {
            System.out.println(q.getQuestion());
            if (input.nextLine().equals(q.getAnswer())) {
                System.out.println("Correct");
                score++;
            }
            else {
                System.out.println("Incorrect");
            }
        }
        System.out.println("You got " + score + " out of " + Quiz.size());
    }
}
