import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] seq;
    static boolean[] checked;
    static int[] checked_num;

    static int maxRes = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        seq = new int[N];
        checked = new boolean[N];
        checked_num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        backtracking(0);

        System.out.println(maxRes);
    }


    public static void backtracking(int cnt) {

        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(checked_num[i]-checked_num[i+1]);
            }

            maxRes = Math.max(sum, maxRes);
            return;
        }

        for (int i = 0; i < N; i++) {

            if(checked[i]) continue;
            checked[i] = true;
            checked_num[cnt] = seq[i];
            backtracking(cnt + 1);
            checked[i] = false;

        }
    }

}
