import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int H, W;
    static Queue<int[]> q = new LinkedList<>();

    static int[][] board;
    static int[][][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        board = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.offer(new int[]{0, 0});
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                int move = temp[2];

                if (isRange(nextY, nextX)) {
                    if (board[nextY][nextX] == 0) {

                    }
                }
            }

        }
        return -1;
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < H && x >= 0 && x < W) return true;
        return false;
    }
}
