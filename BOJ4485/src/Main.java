import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        int[][] dist = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[0][0] = board[0][0];
        pq.offer(new Point(0, 0, board[0][0]));

        while(!pq.isEmpty()) {
            Point p = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = p.row + dy[i];
                int nextCol = p.col + dx[i];

                if(isValid(nextRow, nextCol)) {
                    if (dist[nextRow][nextCol] > dist[p.row][p.col] + board[nextRow][nextCol]) {
                        dist[nextRow][nextCol] = dist[p.row][p.col] + board[nextRow][nextCol];
                        pq.offer(new Point(nextRow, nextCol, dist[nextRow][nextCol]));
                    }
                }
            }
        }

        System.out.println(dist[N-1][N-1]);

    }

    static boolean isValid(int row, int col) {
        if(row < 0 || row >= N || col < 0 || col >= N) return false;
        return true;
    }

}

class Point implements Comparable<Point>{
    int row, col, weight;

    public Point(int row, int col, int weight) {
        this.row = row;
        this.col = col;
        this.weight = weight;
    }

    @Override
    public int compareTo(Point o) {
        return this.weight - o.weight;
    }
}
