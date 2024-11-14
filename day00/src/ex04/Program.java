import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
// -> input String -> char[] -> HashMap<Character, Integer> (где Integer-частота встречаемости char)
public class Program {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        String inputLine = "";
        HashMap<Character, Integer> charsStorage = new HashMap<>();

        try {
            sc = new Scanner(System.in);
            if (sc.hasNextLine()) inputLine = sc.nextLine();

        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        char[] stringToChars = inputLine.toCharArray();
        for (char c : stringToChars) {
            if (!charsStorage.containsKey(c)) charsStorage.put(c, 1);
            else charsStorage.put(c, (charsStorage.get(c))+1);
        }


        printStatistics(charsStorage);
    }

    static void printStatistics(HashMap<Character, Integer> charsStorage) {

    }

}