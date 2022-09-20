import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  shinmj
 * date : 22. 9. 20.
 * description : 동전1 - 다시풀기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int n, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] values = new int[n];
        int[] dp = new int[k + 1]; // 가치가 i인 경우의 수

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = values[i]; j <= k; j++) {
                    dp[j] = dp[j - values[i]] + dp[j];

            }
        }

        System.out.println(dp[k]);
    }
}
