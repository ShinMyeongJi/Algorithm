import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  shinmj
 * date : 22. 10. 13.
 * description :
 */
public class Main {

    static int N;
    static char[][] board;
    static boolean[][] visited;

    static final int NON_BLIND = 0;
    static final int BLIND = 1;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        visited = new boolean[N][N];

        int nonBlind = 0;
        int blind = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, board[i][j], NON_BLIND);
                    nonBlind++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, board[i][j], BLIND);
                    blind++;
                }
            }
        }

        System.out.println(nonBlind + " " + blind);


    }

    public static void dfs(int y, int x, char color, int isBlind) {
        visited[y][x] = true;


        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isRange(nextY, nextX)) {

                if (!visited[nextY][nextX]) {

                    if (isBlind == NON_BLIND) { // 색맹 아닐 때
                        if (board[nextY][nextX] == color) {
                            dfs(nextY, nextX, color, isBlind);
                        }
                    } else if (isBlind == BLIND) { // 색맹 일 때

                        if (color == 'R' || color == 'G') {
                            if (board[nextY][nextX] == 'R' || board[nextY][nextX] == 'G') {
                                dfs(nextY, nextX, color, isBlind);
                            }
                        } else {
                            if (board[nextY][nextX] == color) {
                                dfs(nextY, nextX, color, isBlind);
                            }
                        }


                    }
                }
            }

        }
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= N);
    }
}
