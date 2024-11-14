import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        int countOfInputsLeft = 2;
        boolean timeToStop = false;
        String currentWeekInput = "";
        String gradesInput = "";
        String previousWeekInput = "";
        HashMap<String, String> weeksAndGrades = new HashMap<>();

        try {
            sc = new Scanner(System.in);
            while (!timeToStop) {
                if (sc.hasNextLine()) currentWeekInput = sc.nextLine();
                if (currentWeekInput.equals("42")) break;
                if (sc.hasNextLine()) gradesInput = sc.nextLine();
                if (!correctOrderOfWeeks(currentWeekInput, previousWeekInput)) {
                    System.err.println("Illegal Argument!");
                    System.exit(-1);
                }
                weeksAndGrades.put(currentWeekInput, gradesInput);
                countOfInputsLeft--;
                if (countOfInputsLeft < 1) timeToStop = true;
                previousWeekInput = currentWeekInput;
            }

        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        printStatistics(weeksAndGrades);
    }

    static boolean correctOrderOfWeeks(String currentWeekInput, String previousWeekInput) throws NumberFormatException {
        boolean correct = true;
        if (previousWeekInput.isEmpty()) return true;
        if (getNumberOfWeek(currentWeekInput) <= getNumberOfWeek(previousWeekInput)) correct = false;

        return correct;
    }

    static int getNumberOfWeek(String week) {
        return Integer.parseInt(week.substring(week.length() - 1, week.length()));
    }

    static void printStatistics(HashMap<String, String> weeksAndGrades) {

        for (Map.Entry<String, String> entry : weeksAndGrades.entrySet()) {
            int min = Integer.MAX_VALUE;
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            String[] tokensToGetInsFrom = value.split(" ");

            for (String token : tokensToGetInsFrom) {
                if (Integer.parseInt(token) < min) min = Integer.parseInt(token);
            }

            for (int i = 0; i < min; i++) {
                System.out.print("=");
            }
            System.out.println(">");
        }

    }

}