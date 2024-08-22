import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            int userAnswerIndex = -1;
            while (userAnswerIndex < 0 || userAnswerIndex >= options.size()) {
                System.out.print("Enter your answer (1-" + options.size() + "): ");
                try {
                    userAnswerIndex = scanner.nextInt() - 1;
                    if (userAnswerIndex < 0 || userAnswerIndex >= options.size()) {
                        System.out.println("Invalid choice, please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter a number.");
                    scanner.next(); 
                }
            }
            if (question.isAnswerCorrect(userAnswerIndex)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + (question.getCorrectAnswerIndex() + 1));
            }
        }
        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
    }
}
