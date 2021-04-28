import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int N, S = 0;
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i  = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum(0, 0);
        System.out.println(cnt);
    }

    public static void sum(int idx, int sum) {
        if(idx >= N) return;
        sum += arr[idx];

        if(sum == S) cnt++;

        sum(idx + 1, sum - arr[idx]);
        sum(idx + 1, sum);
    }



}
