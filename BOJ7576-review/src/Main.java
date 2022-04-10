import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] tomatoes;
    static int N, M;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int result = Integer.MIN_VALUE;

        tomatoes = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) q.offer(new int[]{i, j});
            }
        }

        bfs();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                result = Math.max(result, tomatoes[i][j]);
            }
        }


        System.out.println(result - 1);

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];

                if (isRange(ny, nx) && tomatoes[ny][nx] == 0 /*&& !visited[ny][nx]*/) {
                    tomatoes[ny][nx] = tomatoes[temp[0]][temp[1]] + 1;
                    //visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < M) return true;
        return false;
    }


}