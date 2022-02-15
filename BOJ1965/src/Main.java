import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int n = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] boxes = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int max = -1;
            for (int j = i; j >= 0; j--) {
                if(boxes[j] < boxes[i]) {
                    max = Math.max(max, dp[j]);

                }
            }
            if(max != -1) dp[i] = max + 1;
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);

    }
}
