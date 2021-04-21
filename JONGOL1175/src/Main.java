import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 횟수
        M = Integer.parseInt(st.nextToken()); // 합

        arr = new int[10];
        print(1);
    }

    public static void print(int step) {
        if(step > N) {
            if(M == sum()) {
                for(int i = 1; i <=N; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        for(int i = 1; i <=6; i++) {
            arr[step] = i;
            print(step + 1);
        }

    }

    public static int sum() {
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += arr[i];
        }
        return sum;
    }


}
