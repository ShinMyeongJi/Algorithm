import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] tomatoes;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] drow = {1, -1, 0, 0};
    static int[] dcol = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];
        int res = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }


        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomatoes[i][j] == 0) return;
                res = Math.max(res, tomatoes[i][j]);
            }
        }

        System.out.println(res - 1);

    }

    static void bfs() {
        while(!queue.isEmpty()) {

            int[] start = queue.poll();

            int curRow = start[0];
            int curCol = start[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = start[0] + drow[i];
                int nextCol = start[1] + dcol[i];

                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && tomatoes[nextRow][nextCol] == 0) {
                    tomatoes[nextRow][nextCol] = tomatoes[curRow][curCol] + 1;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

    }
}
