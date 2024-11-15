package ex04;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
// -> input String -> char[] -> HashMap<Character, Integer> (где Integer-частота встречаемости char)
public class Program {
    public static void main(String[] args) throws IOException {
        Scanner sc = null;
        String inputLine = "";
        Map<Character, Integer> charsStorage = null;

        try {
            sc = new Scanner(System.in);
            if (sc.hasNextLine()) inputLine = sc.nextLine();

        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        charsStorage = getCharFrequency(inputLine);
        printStatistics(charsStorage);
        //inputLine.chars().forEach(ch -> System.out.print((char)ch + " "));
        
        printStatistics(charsStorage);
    }

    private static Map<Character, Integer> getCharFrequency(String inputLine) {
        return inputLine.chars().mapToObj(c -> (char) c)
        .collect(Collectors
        .toMap(ch -> ch, ch -> 1, 
        Integer::sum, 
        HashMap::new));
    }

    static void printStatistics(Map<Character, Integer> charsStorage) {

        for (Map.Entry<Character, Integer> entry : charsStorage.entrySet()) {
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