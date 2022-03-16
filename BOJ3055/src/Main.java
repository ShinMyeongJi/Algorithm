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

    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'S') {
                    q.offer(new int[]{i, j});
                }else if (map[i][j] == '*') {
                    water.offer(new int[]{i, j});
                }
            }
        }

        int move = 0;

        while(!q.isEmpty()) {
            waterBfs(); // 1. 물 이동을 먼저 해주고
            bfs(++move); // 2. 고슴도치를 이동 시켜주는데
        }


        if (res == 0) System.out.println("KAKTUS");
        else System.out.println(res);
    }

    public static void bfs(int move) { // 3. 큐에 들어간 것은 이미 이동을 한 것. 으로 이해하면 됨.
        int cnt = q.size();
        while(cnt-- > 0) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if(isRange(nextY, nextX) && !visited[nextY][nextX]) {
                    if (map[nextY][nextX] == '.') {
                        q.offer(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                    }else if (map[nextY][nextX] == 'D') {
                        res = move;
                        q.clear();
                        return;
                    }
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
