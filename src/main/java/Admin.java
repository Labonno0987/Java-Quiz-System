import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Admin {
    public static void startAddingQuestions() {
        Scanner sc = new Scanner(System.in);
        JSONParser parser = new JSONParser();

        List<JSONObject> quizBank = new ArrayList<>();

        try {
            FileReader reader = new FileReader("src/main/resources/quiz.json");
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            for (Object o : jsonArray) {
                quizBank.add((JSONObject) o);
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            System.out.println("No existing quiz data found. Starting fresh.");
        }

        while (true) {
            System.out.print("System:> Input your question\nAdmin:> ");
            String question = sc.nextLine();

            System.out.print("System:> Input option 1:\nAdmin:> ");
            String opt1 = sc.nextLine();
            System.out.print("System:> Input option 2:\nAdmin:> ");
            String opt2 = sc.nextLine();
            System.out.print("System:> Input option 3:\nAdmin:> ");
            String opt3 = sc.nextLine();
            System.out.print("System:> Input option 4:\nAdmin:> ");
            String opt4 = sc.nextLine();

            int answerKey;
            while (true) {
                System.out.print("System:> What is the answer key? (1-4)\nAdmin:> ");
                try {
                    answerKey = Integer.parseInt(sc.nextLine());
                    if (answerKey >= 1 && answerKey <= 4) break;
                    else System.out.println("Answer key must be between 1 and 4.");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                }
            }

            HashMap<String, Object> questionMap = new LinkedHashMap<>();
            questionMap.put("question", question);
            questionMap.put("option 1", opt1);
            questionMap.put("option 2", opt2);
            questionMap.put("option 3", opt3);
            questionMap.put("option 4", opt4);
            questionMap.put("answerkey", answerKey);

            JSONObject questionObj = new JSONObject(questionMap);
            quizBank.add(questionObj);

            System.out.println("System:> Question saved successfully!");

            System.out.print("Do you want to add more questions? (s to continue / q to quit)\nAdmin:> ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("q")) break;
        }

        try (FileWriter file = new FileWriter("src/main/resources/quiz.json")) {
            JSONArray jsonArrayToSave = new JSONArray();
            jsonArrayToSave.addAll(quizBank);  
            file.write(jsonArrayToSave.toJSONString());
            file.flush();
            System.out.println("System:> Quiz bank saved to file!");
        } catch (IOException e) {
            System.out.println("System:> Failed to save quiz bank.");
        }
    }
}
