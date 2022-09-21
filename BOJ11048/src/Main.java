import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  shinmj
 * date : 22. 9. 21.
 * description :
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int N, M;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N + 2][M + 2];
        int[][] dp = new int[N + 2][M + 2];



        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        dp[1][1] = maze[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j + 1] = Math.max(dp[i][j + 1], maze[i][j + 1] + dp[i][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], maze[i + 1][j + 1] + dp[i][j]);
                dp[i + 1][j] = Math.max(dp[i + 1][j], maze[i + 1][j] + dp[i][j]);
            }

        }


        for (int i = 0; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(dp[N][M]);
    }
}
