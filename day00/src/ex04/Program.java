import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        String inputLine;
        HashMap<String, Integer> lettersStorage = new HashMap<>();

        try {
            sc = new Scanner(System.in);
            if (sc.hasNextLine()) inputLine = sc.nextLine();

        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        printStatistics(lettersStorage);
    }

    static void printStatistics(HashMap<String, Integer> lettersStorage) {

    }

}