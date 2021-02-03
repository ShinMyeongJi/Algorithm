import java.util.Scanner;

/**
 * BOJ 10996
 */
public class Main {
    public static void main(String[] args){
        int N = 0;
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        int a, b;

        if(N % 2 != 0) {
            a = N/2 + 1;
            b = N/2;
        }else{
            a = N/2;
            b = N/2;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < a; j++){
                System.out.print("* ");
            }
            System.out.println();
            for(int j = 0; j < b; j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
