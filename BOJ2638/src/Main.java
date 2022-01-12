import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.OperatingSystemMXBean;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2638
 */
public class Main {
    static int N,M, time;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }



    }

    public static void inOutCheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 0;
            }
        }

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0));
        visited[0][0] = 1;

        while(!queue.isEmpty()) {

            Point now = queue.poll();
            int x = now.getX();
            int y = now.getY();

            for (int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if(tx >= 0 && ty >= 0 && tx < M && ty < N && visited[ty][tx] == 0 && board[ty][tx] != 1) {
                    visited[ty][tx] = 1;
                    board[ty][tx] = 3;
                    queue.add(new Point(tx, ty));
                }
            }

        }
    }


    public static void calculate() {
        while(true) {
            inOutCheck();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(board[i][j] == 1) {
                        int cnt = 0;

                        for (int k = 0; k < 4; k++) {
                            int ty = i + dy[k];
                            int tx = j + dx[k];

                            if(board[ty][tx] == 3) {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
