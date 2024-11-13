import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException{
        Scanner sc = null;
        int countOfInputsRemainig = 18;
        String inputString = "";
        try {
            sc = new Scanner(System.in);
            if (sc.hasNextLine()) inputString = sc.nextLine();

            while (!inputString.equals("42") & countOfInputsRemainig > 1) {
                if (!correctOrderOfWeeks(inputString)) {
                    if (sc.hasNextInt()) inputString = sc.nextLine();
                    System.err.println("Illegal Argument!");
                    System.exit(-1);
                }
                countOfInputsRemainig--;
            }

        } finally {
            if (sc != null) {
                sc.close(); 
            }
        }
    }

    static boolean correctOrderOfWeeks(String s){

        return true;
    }

    void printlStatistics(int number) {

    }
}