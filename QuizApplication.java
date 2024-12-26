//java
import java.util.*;

public class QuizApplication {

    static Scanner scanner = new Scanner(System.in);
    static boolean timeUp = false;

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz!");
        System.out.println("You will have 10 seconds to answer each question.");
        System.out.println("Let's begin!\n");

        List<Question> questions = Arrays.asList(
                new Question("What is the capital of France?", "B", Arrays.asList("A. Berlin", "B. Paris", "C. Madrid", "D. Rome")),
                new Question("What was the first person to walk?", "B", Arrays.asList("A. Buzz Aldrin", "B. Neil Armstrong", "C. John Glenn", "D. Yuri Gagarin")),
                new Question("Who wrote 'Romeo and Juliet'?", "A", Arrays.asList("A. Shakespeare", "B. Dickens", "C. Hemingway", "D. Austen")),
                new Question("Who invented the telephone?", "A", Arrays.asList("A. Alexander Graham Bell", "B. Thomas Edison", "C. Gugliemo Marconi", "D. Nikola Tesla"))
                );


        int score = 0;
        for (Question question : questions) {
            if (askQuestion(question)) {
                score++;
            }
        }

        System.out.println("\nQuiz Over! Your score: " + score + "/" + questions.size());
        System.out.println("\nThankyou for play! Goodbye!");
    }

    public static boolean askQuestion(Question question) {
        System.out.println("Question: " + question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }

        timeUp = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up!");
            }
        }, 10000); // 10 seconds

        String answer = null;
        if (!timeUp) {
            answer = scanner.nextLine();
        }

        timer.cancel();

        if (!timeUp && question.isCorrect(answer)) {
            System.out.println("Correct!\n");
            return true;
        } else if (!timeUp) {
            System.out.println("Wrong! The correct answer was: " + question.getAnswer() + "\n");
        }
        return false;
    }
}

class Question {
    private String question;
    private String answer;
    private List<String> options;

    public Question(String question, String answer, List<String> options) {
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer != null ? userAnswer.trim() : "");
    }

}