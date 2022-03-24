import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[][][] boxes;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[N][M][H];
        for(int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[j][k][i] = Integer.parseInt(st.nextToken());
                    if (boxes[j][k][i] == 1) q.offer(new int[]{j, k, i});
                }
             }
        }

        bfs();

        if (check()) System.out.println(res);
        else System.out.println(-1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] points = q.poll();

            for (int i = 0; i < 6; i++) {
                int nextY = points[0] + dy[i];
                int nextX = points[1] + dx[i];
                int nextH = points[2] + dh[i];

                if (isRange(nextY, nextX, nextH) && boxes[nextY][nextX][nextH] == 0) {
                    boxes[nextY][nextX][nextH] = boxes[points[0]][points[1]][points[2]] + 1;
                    q.offer(new int[]{nextY, nextX, nextH});
                }
            }
        }
    }

    public static boolean isRange(int y, int x, int h) {
        if (y >= 0 && y < N && x >= 0 && x < M && h >= 0 && h < H) return true;
        return false;
    }

    public static boolean check() {
        for(int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(boxes[j][k][i] == 0) return false;
                    res = Math.max(boxes[j][k][i] - 1, res);
                }
            }
        }

        return true;
    }
}
