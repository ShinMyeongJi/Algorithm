import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer> cnts = new ArrayList<>();
    static int[][] houses;
    static boolean[][] visited;
    static int cnt;
    static int[] dcol = {1, -1, 0, 0};
    static int[] drow = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(houses[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    cnts.add(cnt);
                }
            }
        }

        Collections.sort(cnts);

        System.out.println(cnts.size());

        for (int cnt : cnts) {
            System.out.println(cnt);
        }

    }

    static void dfs(int row, int col) {

        cnt += 1;
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];

            if(nextCol >= 0 && nextRow >=0 && nextCol < N && nextRow < N) {
                if(houses[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    dfs(nextRow, nextCol);
                }
            }
        }
    }
}
