import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N = 0;
    private static int M = 0;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        int N, M = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[6];

        if(M == 1) dice1(1);
        else if(M == 2) dice2(N);
        else if(M == 3) dice3(N);
    }

    private static void dice1(int step) {
        if(step > N) {
            print();
            return;
        }

        for(int i = 1; i <= 6; i++) {
            arr[step] = i;
            dice1(step + 1);
        }
    }

    private static void dice2(int N) {

    }

    private static void dice3(int N) {

    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
