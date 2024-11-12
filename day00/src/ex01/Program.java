import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int input = 0;
            if (sc.hasNextInt()){
                input = sc.nextInt();
            }
            if (input < 2) {
                System.err.println("Illegal Argument!");
            }
            else {
            System.out.println(isPrime(input));
            }
        } finally {
            if (sc != null) {
                sc.close(); 
            }
        }
    }

    static boolean isPrime(int n){
        if (n%2 == 0 || n == 1) {
            return n == 2;
        }

        int d = 3;
        while (d * d <= n && n % d !=0) {
            d += 2;
        }
        return d * d > n;
    }
}