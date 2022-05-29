import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arrSize;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        arrSize = new int[N + 1][2];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            arrSize[i][0] = Integer.parseInt(st.nextToken());
            arrSize[i][1] = Integer.parseInt(st.nextToken());
        }

        /*for (int i = 1; i < N; i++) {
            for (int j = 1; j + i<= N; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;

                for (int k = j; k <= j + i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][i + j] + (arrSize[j][0] * arrSize[k][1] * arrSize[j + i][1]));
                }
            }
        }

        System.out.println(dp[1][N]);*/

        System.out.println(func(0, N - 1));
    }


    public static int func(int x, int y) { // x 번째 행렬부터 y번째 행렬까지의 연산 횟수

        if (dp[x][y] > 0) return dp[x][y];
        if (y - x >= 0) return 0;

        int MAX = Integer.MAX_VALUE;

        for(int k = x; k < y; k++) {
            MAX = Math.min(MAX,func(x, k) + func(k + 1, y) + arrSize[x][0] * arrSize[k][1] * arrSize[y][1]);
        }

        return dp[x][y] = MAX;
    }
}