import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Question q1 = new Question(
            "What is the capital of india?",
            Arrays.asList("Berlin", "Madrid", "delhi", "Rome"),
            2
        );
        Question q2 = new Question(
            "What is 22 + 23?",
            Arrays.asList("35", "45", "55", "65"),
            1
        );
        Question q3 = new Question(
            "Who wrote indian constution?",
            Arrays.asList("modi", "ambedkar", "jagan", "murummu"),
            1
        );

        List<Question> questions = Arrays.asList(q1, q2, q3);
        Quiz quiz = new Quiz(questions);

        
        quiz.startQuiz();
    }
}
