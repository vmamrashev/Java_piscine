public class Program
{
public static void main(String[] args) {
    int x = 479598;
    int sum = 0;
    if (x < 0) x = -x;
    
    while (x != 0) {
        sum += x % 10;
        x /= 10;
    }
    System.out.println(sum);
  }
}