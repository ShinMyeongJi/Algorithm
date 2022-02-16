import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        long[][] dp = new long[n][n];

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 || (i == n - 1 && j == n - 1)) continue;

                int val = board[i][j];
                int nextI = val + i;
                int nextJ = val + j;

                if(nextI < n) dp[nextI][j] = dp[i][j] + dp[nextI][j];
                if(nextJ < n) dp[i][nextJ] = dp[i][j] + dp[i][nextJ];

            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
