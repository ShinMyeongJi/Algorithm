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
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        q.offer(new int[]{0, 0});

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX)) {

                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < M) return true;
        return false;
    }
}
