import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M = 0; // col, row
    static boolean[][] visited;
    static char[][] field;
    static int[] powers  = new int[2]; // 0 : W, 1 : B

    static int[] dcol = {1, -1, 0, 0};
    static int[] drow = {0, 0, 1, -1};

    static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(field[i][j] == 'W' && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j, 'W');
                    powers[0] += cnt * cnt;
                }

                if (field[i][j] == 'B' && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j, 'B');
                    powers[1] += cnt * cnt;
                }
            }
        }

        System.out.println(powers[0] + " " + powers[1]);
    }

    static void dfs(int col, int row, char py) {

        cnt = cnt + 1;
        visited[col][row] = true;

        for (int i = 0; i < 4; i++) {
            int nextCol = col + dcol[i];
            int nextRow = row + drow[i];

            if (nextCol >= 0 && nextCol < M && nextRow >= 0 && nextRow < N && field[nextCol][nextRow] == py && !visited[nextCol][nextRow]) {
                visited[nextCol][nextRow] = true;
                dfs(nextCol, nextRow, py);
            }
        }
    }
}
