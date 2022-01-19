import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        int[][] dist = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[0][0] = board[0][0];
        pq.offer(new Point(0, 0, board[0][0]));

        while(!pq.isEmpty()) {
            Point p = pq.poll();

            for (int i = 0; i < 4; i++) {

            }



        }

    }
}

class Point {
    int row, col, weight;

    public Point(int row, int col, int weight) {
        this.row = row;
        this.col = col;
        this.weight = weight;
    }
}
