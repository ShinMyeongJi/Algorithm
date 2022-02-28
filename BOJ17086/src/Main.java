import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N; // 세로
    static int M; // 가로
    static int[][] space;

    static int[] dy = {1, -1, 1, -1, 1, -1, 0, 0}; // 세로
    static int[] dx = {-1, 1, 1, -1, 0, 0, 1, -1}; // 가로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (space[i][j] == 0) {
                    space[i][j] = bfs(i, j);
                }
            }
        }

       for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               System.out.print(space[i][j] + " ");
           }
           System.out.println();
       }

    }

    public static int bfs(int i, int j) {
        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            for (int k = 0; k < 8; k++) {
                int nextI = temp[0] + dy[k];
                int nextJ = temp[1] + dx[k];

                if(nextI < N && nextI >= 0 && nextJ < M && nextJ >= 0) {
                    if (space[nextI][nextJ] != 1) {
                        cnt += 1;
                        q.offer(new int[]{nextI, nextJ});
                    }else {
                        return cnt;
                    }

                }
            }
        }

        return cnt;

    }
}
