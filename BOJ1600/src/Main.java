import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제를 잘못 이해해서 말의 움직임의 좌표가 정해져있는지 몰랐다..;
 */
public class Main {

    static int K;
    static int H, W;
    static Queue<int[]> q = new LinkedList<>();

    static int[][] board;
    static int[][][] visited;

    static int[] dy = {1, -1, 0, 0}; // 일반 사방탐색
    static int[] dx = {0, 0, 1, -1};

    static int[] horseY = {-2, -1, 2, 1, -2, -1, 2, 1}; // 말의 움직임
    static int[] horseX = {-1, -2, -1, -2, 1, 2, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        visited = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.offer(new int[]{0, 0, 0});

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            int curY = temp[0];
            int curX = temp[1];
            int curK = temp[2];

            if(curY == H - 1 && curX == W - 1) {
                return visited[curY][curX][curK];
            }
            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (isRange(nextY, nextX, curK)) {
                    if(visited[nextY][nextX][curK] == 0){
                        visited[nextY][nextX][curK] = visited[curY][curX][curK] + 1;
                        q.offer(new int[]{nextY, nextX, curK});
                    }
                }
            }

            if (curK < K) {     // 아직 말처럼 뛸 수 있다면
                for (int i = 0; i < 8; i++) {
                    int nextY = curY + horseY[i];
                    int nextX = curX + horseX[i];

                    if (isRange(nextY, nextX, curK)) {
                        if(visited[nextY][nextX][curK + 1] == 0) { // 말처럼 뛰었을 때의 루트를 체크한다. (아직 방문하지 않았는지)
                            visited[nextY][nextX][curK + 1] = visited[curY][curX][curK] + 1; //
                            q.offer(new int[]{nextY, nextX, curK + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isRange(int y, int x, int k) {
        if (y >= 0 && y < H && x >= 0 && x < W)  {
            if (board[y][x] == 0) {
                return true;
            }
        }
        return false;
    }
}
