import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = null;
        int input = 0;
        int count = 0;
        try {
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) input = sc.nextInt();

            while (input != 42) {
                if (isPrime(sumOfDigits(input))) {
                    count++;
                }
                if (sc.hasNextInt()) input = sc.nextInt();
            }

        } finally {
            if (sc != null) {
                sc.close(); 
            }
        }
        System.out.println("Count of coffee-request - " + count);
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

    static int sumOfDigits(int number) {
        int sum = 0;
        if (number < 0) number = -number;
        
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}