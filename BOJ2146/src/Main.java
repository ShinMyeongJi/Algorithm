import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] country;

    static Queue<int[]> q = new LinkedList<>();

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static boolean[][] visited;
    static int label = 1;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        country = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 섬의 다른 Label 부여하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && country[i][j] == 1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    label++;
                    country[i][j] = label;
                    changeAreaLabel();
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (country[i][j] != 0) {
                    visited = new boolean[N][N];
                    q = new LinkedList<>();
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;

                    int res = bfs(i, j);

                    if (res >= 0) min = Math.min(min, res);
                }
            }
        }

        System.out.println(min);
    }

    public static int bfs(int y, int x) {


        int curLabel = country[y][x];

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int cur = country[temp[0]][temp[1]];

            if (cur != 0 && cur != curLabel) return temp[2];

            for(int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];
                int cnt = temp[2];

                if (isRange(nextY, nextX) && !visited[nextY][nextX] && country[nextY][nextX] != cur) {
                    visited[nextY][nextX] = true;
                    q.offer(new int[]{nextY, nextX, cnt + 1});
                }
            }
        }

        return -1;
    }

    public static void changeAreaLabel() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX) && country[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    country[nextY][nextX] = label;
                    visited[nextY][nextX] = true;
                    q.offer(new int[]{nextY, nextX});
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < N) return true;
        return false;
    }
}
