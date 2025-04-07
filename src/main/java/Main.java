import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JSONParser parser = new JSONParser();

        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("users.json");
            assert inputStream != null;
            JSONArray users = (JSONArray) parser.parse(new InputStreamReader(inputStream));


            System.out.print("System:> Enter your username\nUser:> ");
            String username = sc.nextLine();
            System.out.print("System:> Enter password\nUser:> ");
            String password = sc.nextLine();

            boolean found = false;

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                String uname = (String) user.get("username");
                String pass = (String) user.get("password");
                String role = (String) user.get("role");

                if (uname.equals(username) && pass.equals(password)) {
                    found = true;
                    if (role.equals("admin")) {
                        System.out.println("System:> Welcome admin! Please create new questions in the question bank.");
                        Admin.startAddingQuestions();
                    } else {
                        System.out.println("System:> Welcome " + username + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
                        String input = sc.nextLine();
                        if (input.equalsIgnoreCase("s")) {
                            Student.startQuiz();
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Invalid login credentials.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

