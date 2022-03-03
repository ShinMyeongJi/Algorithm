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


    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];

        // way 1 - 1부터 시작해 다른 1부터 시작했을 때 보다 이동거리가 작으면 교체
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 1) q.offer(new int[]{i, j});
            }
        }

        bfs();

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res = Math.max(res, space[i][j] - 1);
            }
        }

        System.out.println(res);
    }

    public static void bfs() {
        while (!q.isEmpty()){
            int[] temp = q.poll();

            for (int k = 0; k < 8; k++) {
                int nextI = temp[0] + dy[k];
                int nextJ = temp[1] + dx[k];

                if (nextI < N && nextI >= 0 && nextJ < M && nextJ >= 0) {
                    if (space[nextI][nextJ] == 0 || (space[nextI][nextJ] > space[temp[0]][temp[1]] + 1)) {
                        space[nextI][nextJ] = space[temp[0]][temp[1]] + 1;
                        q.offer(new int[]{nextI, nextJ});
                    }
                }
            }
        }
    }

    // way 2 - 1부터 시작해서....
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 1) q.offer(new int[]{i, j});
            }
        }

        bfs();

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               res = Math.max(res, space[i][j] - 1);
               System.out.print(space[i][j] + " ");
           }
            System.out.println();
        }

        System.out.println(res);
    }

    public static void bfs() {
        while (!q.isEmpty()){
            int[] temp = q.poll();

            for (int k = 0; k < 8; k++) {
                int nextI = temp[0] + dy[k];
                int nextJ = temp[1] + dx[k];

                if (nextI < N && nextI >= 0 && nextJ < M && nextJ >= 0) {
                    if (!visited[nextI][nextJ]){
                        if (space[nextI][nextJ] == 1) continue;

                        q.offer(new int[]{nextI, nextJ});
                        visited[nextI][nextJ] = true;
                        space[nextI][nextJ] = space[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
    }*/
}

// way 3 - 0부터 시작하기 (다시 해보기)
/* for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (space[i][j] == 0) {
                    ds[i][j] = bfs(i, j);
                }
            }
        }
*/

    /*public static int bfs(int i, int j) {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            for(int d = 0; d < q.size(); d++) {
                int[] temp = q.poll();

                for (int k = 0; k < 8; k++) {
                    int nextI = temp[0] + dy[k];
                    int nextJ = temp[1] + dx[k];

                    if (nextI < N && nextI >= 0 && nextJ < M && nextJ >= 0) {

                        if (space[nextI][nextJ] == 1) return cnt + 1;

                        if (!visited[nextI][nextJ]) {
                            //space[nextI][nextJ] = space[i][j] + 1;
                            q.offer(new int[]{nextI, nextJ});
                            visited[nextI][nextJ] = true;
                        }
                    }
                }
            }

            cnt += 1;
        }

        return cnt;

    }*/