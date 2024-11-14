import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException{
        Scanner sc = null;
        int countOfInputsLeft = 18;
        String inputString = "";
        String currentWeekInput ="";
        String gradesInput ="";
        String previouseWeekInput ="";
        HashMap<String, String> weeksAndGrades = new HashMap<>();
        ///////////////////////
        //currentWeekInput ="Week 1";
        //gradesInput ="11 12 13 14 10 12 15 16";
        //weeksAndGrades.put(currentWeekInput, gradesInput);
        //printStatistics(weeksAndGrades);
        ///////////////////////
        
        try {
            sc = new Scanner(System.in);
            while (!inputString.equals("42") & countOfInputsLeft > 1) {
                if (sc.hasNextLine()) currentWeekInput = sc.nextLine();
                if (sc.hasNextLine()) gradesInput = sc.nextLine();
                if (!correctOrderOfWeeks(currentWeekInput, previouseWeekInput)){
                    System.err.println("Illegal Argument!");
                    System.exit(-1);
                }
                weeksAndGrades.put(currentWeekInput, gradesInput);
                previouseWeekInput = currentWeekInput;
                countOfInputsLeft--;
            }

        } finally {
            if (sc != null) {
                sc.close(); 
            }
        }

        printStatistics(weeksAndGrades);
    }

    static boolean correctOrderOfWeeks(String currentWeekInput, String previouseWeekInput) throws NumberFormatException{
        boolean correct = true;
        if (previouseWeekInput.equals("")) return true;
        if (getNumberOfWeek(currentWeekInput) <= getNumberOfWeek(previouseWeekInput)) correct = false;

        return correct;
    }

    static int getNumberOfWeek(String week){
        return Integer.parseInt(week.substring(week.length() - 1, week.length()));
    }

    static void printStatistics(HashMap<String, String> weeksAndGrades) {
        
        for (Map.Entry<String, String> entry : weeksAndGrades.entrySet()) {
            int min =Integer.MAX_VALUE;
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            String[] tokensToGetInsFrom = value.split(" ");

            for (String  token: tokensToGetInsFrom) {
                if (Integer.parseInt(token) < min) min = Integer.parseInt(token);
            }
            
            for (int i = 0; i < min; i++) {
                System.out.print("=");
            }
            System.out.println(">");
        }
        
    }
    
}