import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  shinmj
 * date : 22. 9. 24.
 * description :
 */

public class Main {

    static int N, M;
    static int[][] values;
    static int[][] dp;

    static int[] dy = {-1, 0, 0}; // 위축 (행)
    static int[] dx = {0, 1, -1};

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1, 1);
        System.out.println(dp[N -1][M - 1]);
    }


    public static int DFS(int i, int j) {
        if (i == N && j == M) return values[N - 1][M - 1];


        for (int k = 0; k < 3; k++) {

            int nextY = i + dy[k];
            int nextX = j + dx[k];

            if (isRange(nextY, nextX)) {
                dp[i][j] = Math.max(dp[i][j], DFS(nextY, nextX) + values[i][j]);
            }
        }


        return dp[i][j];
    }

    public static boolean isRange(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N) return false;

        return true;
    }
}
