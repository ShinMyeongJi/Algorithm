import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Queue<int[]> q = new LinkedList<>();

    static int[][] map;
    static int[][][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        q.offer(new int[]{0, 0, 0});

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            if (temp[0] == N - 1 && temp[1] == M - 1) return visited[temp[0]][temp[1]][temp[2]] + 1;

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                int isBroken = temp[2];

                if (isRange(nextY, nextX) && visited[nextY][nextX][isBroken] == 0) {
                    // 벽을 부수고 도달했든 부수지 않고 도달했든 방문한 적이 있으면 더 이상 진행하지 않는다.
                    if(map[nextY][nextX] == 0) {
                        visited[nextY][nextX][isBroken] = visited[temp[0]][temp[1]][isBroken] + 1;
                        q.offer(new int[]{nextY, nextX, isBroken});
                    }

                    if (map[nextY][nextX] == 1 && isBroken == 0) {
                        visited[nextY][nextX][1] = visited[temp[0]][temp[1]][isBroken] + 1;
                        isBroken = 1;
                        q.offer(new int[]{nextY, nextX, isBroken});
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < M) return true;
        return false;
    }
}
