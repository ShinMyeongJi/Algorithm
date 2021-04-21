import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * JONGOL 1169
 * 재귀 응용 문제 풀고 다시 풀어보기!
 */
public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[7];
        chk = new boolean[7];
        arr[0] = 1;
        if(M == 1) dice1(1);
        else if(M == 2) dice2(1);
        else if(M == 3) dice3(1);
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

    private static void dice2(int step) {
        if(step > N) {
            print();
            return;
        }

        for(int i = arr[step-1]; i <= 6; i++) {
            arr[step] = i;
            dice2(step + 1);
        }
    }

    private static void dice3(int step) {
        if(step > N){
            print();
            return;
        }

        for(int i = 1; i <= 6; i++) {
            if(chk[i]) continue;
            chk[i] = true;
            arr[step] = i;
            dice3(step + 1);
            chk[i] = false;
        }


    }

    private static void print() {
        for(int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
