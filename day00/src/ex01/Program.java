import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int input = 0;
            if (sc.hasNextInt()) {
                input = sc.nextInt();
            }
            if (input < 2) {
                System.err.println("Illegal Argument!");
                System.exit(-1);
            } else {
                int d = 3;
                int iterationCounter = 1;
                boolean isPrime = false;
                if (input % 2 != 0) {
                    while (d * d <= input && input % d != 0) {
                        d += 2;
                        iterationCounter++;
                    }
                }
                isPrime = d * d > input;
                System.out.println(isPrime + " " + iterationCounter);
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}