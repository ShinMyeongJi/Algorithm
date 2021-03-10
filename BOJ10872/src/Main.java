import java.util.Scanner;

/**
 * BOJ 10872
 * 기본 팩토리얼
 */

public class Main {
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        System.out.println(factorial(N));
    }

    public static int factorial(int N) {
        if(N == 0) return 1;
        return N*factorial(N-1);
    }
}
