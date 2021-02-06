
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * BOJ 10870
 */
public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int N;

        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[N+1];

        if(N == 0)
            arr[0] = 0;
        else if(N == 1){
            arr[0] = 0;
            arr[1] = 1;
        }else {
            arr[0] = 0;
            arr[1] = 1;
            fibonacci(0);
        }

        bw.write(arr[N] + "");

        bw.flush();
        bw.close();
    }

    public static void fibonacci(int N){

        arr[N+2] = arr[N+1] + arr[N];

        if(N == arr.length-3) return;
        fibonacci(N+1);
    }
}
