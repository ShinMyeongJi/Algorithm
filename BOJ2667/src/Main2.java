import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  shinmj
 * date : 22. 9. 26.
 * description :
 */
public class Main2 {

    static int n;
    static Queue<int[]> q = new LinkedList();
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int dfsCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        List<Integer> resSeq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {

                    //bfs
                    q.offer(new int[]{i, j});
                    resSeq.add(bfs());

                    //dfs
                    //dfsCnt = 0;
                    //dfs(i, j);
                    //resSeq.add(dfsCnt);
                }
            }
        }

        Collections.sort(resSeq);
        System.out.println(resSeq.size());
        for (int i : resSeq) {
            System.out.println(i);
        }

    }

    public static int bfs() {
        int cnt = 1;

        while (!q.isEmpty()) {

            int[] temp = q.poll();

            visited[temp[0]][temp[1]] = true;

            for (int k = 0; k < 4; k++) {
                int nextY = temp[0] + dy[k];
                int nextX = temp[1] + dx[k];

                if (isRange(nextY, nextX) && !visited[nextY][nextX]) {

                    if (map[nextY][nextX] == 1) {
                        q.offer(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                        cnt++;
                    }

                }
            }
        }

        return cnt;
    }


    public static void dfs(int i, int j) {

        visited[i][j] = true;
        dfsCnt++;

        for (int k = 0; k < 4; k++) {
            int nextY = i + dy[k];
            int nextX = j + dx[k];

            if (isRange(nextY, nextX) && !visited[nextY][nextX]) {
                if (map[nextY][nextX] == 1) {
                    dfs(nextY, nextX);
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= n || x < 0 || x >= n);
    }
}
