import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  home
 * date : 22. 10. 11.
 * description :
 */
public class Main2 {
    static int N;
    static int[][] area;
    static boolean[][] visited;

    static int maxHeight = Integer.MIN_VALUE; // 범위
    static int areaSumMax; // 물에 잠기지 않는 영역의 최대 개수

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        visited = new boolean[N][N];


        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(area[i][j], maxHeight);
            }
        }


        for (int k = 0; k <= maxHeight; k++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] > k && !visited[i][j]) {
                        dfs(k, i, j);
                        cnt++;
                    }
                }
            }
            areaSumMax = Math.max(cnt, areaSumMax);
            init();
        }

        System.out.println(areaSumMax == Integer.MIN_VALUE ? 1 : areaSumMax);


    }

    public static void dfs(int range, int y, int x) {

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isRange(nextY, nextX)) {
                if (!visited[nextY][nextX] && area[nextY][nextX] > range) { // 잠기는 곳 체크를 해줘야겠지...
                    dfs(range, nextY, nextX);
                }
            }
        }
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= N);
    }
}
