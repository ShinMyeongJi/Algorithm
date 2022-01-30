import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[][] tomatoes;
    static Queue<int []> queue = new LinkedList<>();

    static int[] drow = {1, -1, 0, 0};
    static int[] dcol = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int result = Integer.MIN_VALUE;

        tomatoes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }


        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                result = Math.max(result, tomatoes[i][j] - 1);
            }
        }

        System.out.println(result);
    }

    static void bfs() {
        while(!queue.isEmpty()) {
             int[] idxs = queue.poll();
             int nowX = idxs[0];
             int nowY = idxs[1];

             for (int i = 0 ; i < 4; i++) {
                 int nextX = nowX + drow[i];
                 int nextY = nowY + dcol[i];

                 if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && tomatoes[nextX][nextY] == 0) {
                     tomatoes[nextX][nextY] = tomatoes[nowX][nowY] + 1;
                     queue.offer(new int[]{nextX, nextY});
                 }
             }
        }
    }
}
