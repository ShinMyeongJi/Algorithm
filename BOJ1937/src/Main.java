import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  home
 * date : 22. 9. 24.
 * description : 욕심쟁이 판다
 */
public class Main {

    static int N;

    static int[][] rooms;
    static int[][] dp;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        rooms = new int[N][N];
        dp = new int[N][N];

        int max = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                //DFS
                // dp[i][j] = i,j 부터 시작했을 때의 최대 경로
                max = Math.max(max, DFS(i, j));
            }
        }

        System.out.println(max);
    }

    // i,j 부터 시작할 경우의 최대값 구하기
    public static int DFS(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];

        dp[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int nextY = i + dy[k];
            int nextX = j + dx[k];

            if (isRange(nextY, nextX)) {
                if(rooms[nextY][nextX] > rooms[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], DFS(nextY, nextX) + 1);
                }
            }
        }

        return dp[i][j];
    }



    public static boolean isRange(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N) return false;

        return true;
    }
}
