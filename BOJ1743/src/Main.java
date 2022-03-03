import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 세로
    static int M; // 가로
    static int K;

    static char[][] hallways;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int res = Integer.MIN_VALUE;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        hallways = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;

            hallways[row][col] = '#';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (hallways[i][j] == '#') {
                    res = Math.max(bfs(i, j, 0), res);
                }
            }
        }

        System.out.println(res);
    }

    public static int bfs(int row, int col, int cnt) {
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{row, col});

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = temp[0] + dy[i];
                int nextCol = temp[1] + dx[i];

                if (isRange(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                    if (hallways[nextRow][nextCol] == '#') {
                        q.offer(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                        cnt += 1;
                    }
                }
            }

        }

        return cnt;
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < M) {
            return true;
        }
        return false;
    }
}
