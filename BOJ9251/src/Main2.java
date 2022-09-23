import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        String str1 = "/".concat(br.readLine());
        String str2 = "/".concat(br.readLine());

        int[][] dp = new int[str1.length()][str2.length()];

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {

                if (str1.charAt(i) == str2.charAt(j)) dp[i][j] = dp[i -1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        /*for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }*/

        System.out.println(dp[str1.length() - 1][str2.length() - 1]);

    }
}
