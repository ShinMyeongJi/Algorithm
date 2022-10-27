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


// 왼쪽 한 번
// 오른쪽 한 번

/**
5 5
10 25 7 8 13
68 24 -78 63 32
12 -69 100 -29 -25
-16 -22 -57 -33 99
7 -76 -11 77 15
 */
public class Main {

    static int N, M;
    static int[][] values;
    static int[][] dp;

    static int[] dy = {0, 1, 0}; // 왼쪽 // 아래 // 오른쪽
    static int[] dx = {-1, 0, 1};

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

        dp[0][0] = values[0][0];
        DFS(0, 0);
        System.out.println(dp[N -1][M - 1]);
    }


    public static void DFS(int startY, int startX) {

        if (startY == 0) { // 맨 첫 줄
            for (int i = 0; i < M - 1; i++) {
                dp[startY][i + 1] = dp[startY][i] + values[startY][i + 1];
            }
            startY += 1;
        }

        for (int i = 0; i < M - 1; i++) {

        }


    }


    public static void print() {
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isRange(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= M) return false;

        return true;
    }
}
