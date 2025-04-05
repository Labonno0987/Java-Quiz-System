
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.*;

public class Student {
    public static void startQuiz() {
        JSONParser parser = new JSONParser();
        Scanner sc = new Scanner(System.in);
        int score = 0;

        try {
            JSONArray quizBank = (JSONArray) parser.parse(new FileReader("src/main/resources/quiz.json"));

            if (quizBank.size() < 10) {
                System.out.println("Not enough questions in the quiz bank.");
                return;
            }

            List<Integer> indexes = new ArrayList<>();
            Random rand = new Random();

            while (indexes.size() < 10) {
                int index = rand.nextInt(quizBank.size());
                indexes.add(index);
            }

            int qNo = 1;
            for (int idx : indexes) {
                JSONObject q = (JSONObject) quizBank.get(idx);
                System.out.println("[Question " + qNo + "] " + q.get("question"));
                System.out.println("1. " + q.get("option 1"));
                System.out.println("2. " + q.get("option 2"));
                System.out.println("3. " + q.get("option 3"));
                System.out.println("4. " + q.get("option 4"));

                System.out.print("\nStudent:> ");
                String input = sc.nextLine();
                try {
                    int ans = Integer.parseInt(input);
                    int correct = ((Long) q.get("answerkey")).intValue();
                    if (ans == correct) {
                        score++;
                    }
                } catch (Exception e) {
                    // invalid input = 0 mark
                }

                qNo++;
            }

            System.out.println("\n========================");
            if (score >= 8) {
                System.out.println("Excellent! You have got " + score + " out of 10");
            } else if (score >= 5) {
                System.out.println("Good. You have got " + score + " out of 10");
            } else if (score >= 2) {
                System.out.println("Very poor! You have got " + score + " out of 10");
            } else {
                System.out.println("Very sorry you are failed. You have got " + score + " out of 10");
            }

            System.out.print("Would you like to start again? press s for start or q for quit\nStudent:> ");
            String again = sc.nextLine();
            if (again.equalsIgnoreCase("s")) {
                startQuiz();
            }

        } catch (Exception e) {
            System.out.println("Error loading quiz bank: " + e.getMessage());
        }
    }
}
