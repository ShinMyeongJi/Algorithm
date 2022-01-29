import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//아무 지역도 물에 안 잠길 수 있다. == 비가 안 올 때
public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int cnt;


    static int[] drow = {0, 0, 1, -1};
    static int[] dcol = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int maxH = 0;
        int res = Integer.MIN_VALUE;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, board[i][j]);
            }
        }


        for (int k = 0; k <= maxH; k++) {
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(k < board[i][j] && !visited[i][j]) {
                        dfs(i, j, k);
                        cnt++;
                    }

                }
            }
            visited = new boolean[N][N];
            res = Math.max(cnt, res);
        }

        System.out.println(res);
    }

    static void dfs(int row, int col, int height) {

        visited[row][col] = true;


        for (int i = 0; i < 4; i++) {
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];

            if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
                if(height < board[nextRow][nextCol] && !visited[nextRow][nextCol])
                    dfs(nextRow, nextCol, height);
            }
        }
    }
}
