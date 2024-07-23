import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(isPrime(input));
    }

    static boolean isPrime(int n){
        if (n%2 == 0) n = 2;
        int d = 3;
        while (d * d <= n && n % d !=0) {
            d += 2;
        }
        return d * d > n;
    }
}