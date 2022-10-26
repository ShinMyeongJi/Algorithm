import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : PACKAGE_NAME
 * fileName       : Main2
 * author         : home
 * date           : 22. 10. 26.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 10. 26.        home       최초 생성
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> part = new ArrayList<>();
        int[] seq = new int[N + 1];
        int[] dp = new int[N + 1];

        int res = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);

        for (int i = N; i > 0; i--) {
            if (dp[i] == res) {
                part.add(seq[i]);
                res--;
            }
        }

        Collections.sort(part);

        for (Integer s : part) {
            System.out.print(s + " ");
        }


    }
}
