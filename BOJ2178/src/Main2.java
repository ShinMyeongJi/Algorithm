import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  shinmj
 * date : 22. 9. 26.
 * description :
 */
public class Main2 {

    static int n, m;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int[][] miroh;
    static int[][] dist;
    static boolean[][] visited;

    static int cnt;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String line;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miroh = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for(int j = 0; j < m; j++) {
                miroh[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        bfs(0, 0);
        System.out.println(dist[n-1][m-1] + 1);
    }

    public static void bfs(int y, int x) {
        //int cnt = 0;

        q.offer(new int[]{y, x});

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {

                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX)) {
                    if (miroh[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.offer(new int[]{nextY, nextX});
                        dist[nextY][nextX] = dist[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
    }


    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= n || x < 0 || x >= m);
    }
}
