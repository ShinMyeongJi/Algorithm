import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS로 풀면 시간초과..
 *
 */

public class Main {

    static int N, M;

    static boolean[][] visited;
    static int[][] board;
    static int[][] dist;
    static int res = Integer.MAX_VALUE;

    static int[] dx = {1, -1, 0, 0}; // 열
    static int[] dy = {0, 0, 1, -1}; // 행
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1][M + 1];
        board = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j + 1] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        //dfs(1, 1, 1);

        bfs(1, 1);
        System.out.println(board[N][M]);

    }

    static void bfs(int row, int col) {
        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y = new LinkedList<>();

        queue_x.offer(row);
        queue_y.offer(col);

        while(!queue_x.isEmpty() && !queue_y.isEmpty()) {
            int r = queue_x.poll();
            int c = queue_y.poll();


            for(int i = 0; i < 4; i++) {
                int nextR = r + dy[i];
                int nextC = c + dx[i];
                if(nextR > 0 && nextR < N + 1 && nextC > 0 && nextC < M + 1) {
                    if (!visited[nextR][nextC] && board[nextR][nextC] == 1) {
                        visited[nextR][nextC] = true;
                        queue_x.offer(nextR);
                        queue_y.offer(nextC);

                        board[nextR][nextC] = board[r][c] + 1;
                    }
                }
            }
        }
    }


    /*static void dfs(int row, int col, int cnt) {
        if(row == N && col == M) {
            res = Math.min(res, cnt);
            return;
        }

        if(cnt > res) return;

        for(int i = 0; i < 4; i++) {
            int nextR = row + dy[i];
            int nextC = col + dx[i];
            if(nextR > 0 && nextR < N + 1 && nextC > 0 && nextC < M + 1) {
                if (!visited[nextR][nextC] && board[nextR][nextC] == 1) {
                    visited[nextR][nextC] = true;
                    dfs(nextR, nextC, cnt + 1);
                    visited[nextR][nextC] = false;
                }
            }
        }
    }*/
}
