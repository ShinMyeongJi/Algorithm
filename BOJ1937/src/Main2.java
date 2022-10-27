import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[][] dp;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new int[N][N];

        int res = -1;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Math.max(dfs(i, j), dp[i][j]);
                res = Math.max(res, dp[i][j]);
            }
        }

        System.out.println(res);
    }

    public static int dfs(int startY, int startX) {


        if (dp[startY][startX] != 0) {
            return dp[startY][startX];
        }

        dp[startY][startX] = 1;
        for (int i = 0; i < 4; i++) {
            int nextY = startY + dy[i];
            int nextX = startX + dx[i];

            if (isRange(nextY, nextX)) {
                if (board[nextY][nextX] > board[startY][startX]) {
                    dp[startY][startX] = Math.max(dp[startY][startX], dfs(nextY, nextX) + 1);

                }
            }
        }

        return dp[startY][startX];
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= N);
    }
}
