import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S') {
                    q.offer(new int[]{i, j});
                }else if (map[i][j] == '*') {
                    water.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            waterBfs();
            bfs();
        }

    }

    public static void bfs() {
        int cnt = q.size();
        while(cnt-- > 0) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX) && map[nextY][nextX] == '.') {
                    q.offer(new int[]{nextY, nextX});
                }
            }
        }
    }

    public static void waterBfs() {
        int cnt = water.size();
        while(cnt-- > 0) {
            int[] temp = water.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX) && map[nextY][nextX] == '.') {
                    water.offer(new int[]{nextY, nextX});
                    map[nextY][nextX] = '*';
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < R && x >= 0 && x < C) return true;
        return false;
    }
}
