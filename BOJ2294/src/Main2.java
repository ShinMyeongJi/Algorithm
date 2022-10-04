import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  home
 * date : 22. 9. 26.
 * description :
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        int n, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] values = new int[n];
        int[] dp = new int[k + 1]; // 가치가 i일 동전의 최수 개수 때


        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = values[i]; j <= k; j++) {
               dp[j] = Math.min(dp[j], dp[j - values[i]] + 1);
            }
        }

        System.out.println(dp[k]);
    }
}
