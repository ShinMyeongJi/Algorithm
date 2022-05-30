import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        int T = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 3];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[n]);
        }



        //dp(N);
        //System.out.println(cnt);
    }

    static void dp(int N) {


        if(N < 0) return;
        else if(N == 0) {
            cnt++;
            return;
        }else {
            for (int i = 1; i <= 3; i++) {
                dp(N - i);
            }
        }
    }
}
