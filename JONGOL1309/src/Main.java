import java.util.Scanner;

/**
 * JONGOL1309
 */
public class Main {
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        System.out.println(factorial(N));
    }

    private static long factorial(long n) {
        if(n == 1){
            System.out.println(n + "! = " + n);
            return 1;
        }
        System.out.println(n + "! = " + n + " * " + (n-1) + "!");
        return n * factorial(n-1);
    }
}
