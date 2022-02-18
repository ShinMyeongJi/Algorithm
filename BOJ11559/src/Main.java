import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final static int B_ROW = 12;
    final static int B_COL = 6;

    static boolean[][] visited = new boolean[B_ROW][B_COL];
    static char[][] board = new char[B_ROW][B_COL];
    static Queue<int[]> q = new LinkedList<>();

    static int[] dy = {1, -1, 0, 0}; // row
    static int[] dx = {0, 0, 1, -1}; // col

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < B_ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B_COL; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < B_ROW; i++) {
            for (int j = 0; j < B_COL; j++) {
                if (board[i][j] != '.' && !visited[i][j]) {
                    bfs(i, j, 0);
                }
            }
        }

    }

    public static void bfs(int s_row, int s_col, int cnt) {

        q.offer(new int[]{s_row, s_col});

        while(!q.isEmpty()) {

        }
    }
}
