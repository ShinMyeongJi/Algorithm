import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  shinmj
 * date : 22. 9. 22.
 * description :
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, K;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        int[][] dp = new int[N + 1][K + 1];


        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                if (j - weights[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i -1][j], dp[i - 1][j - weights[i]] + values[i]);
            }
        }


        /*for(int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }*/

        System.out.println(dp[N][K]);

    }
}
