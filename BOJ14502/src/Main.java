import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  home
 * date : 22. 10. 20.
 * description :
 */

public class Main {

    static int N, M;
    static int[][] lab;
    static int[][] simulationLab;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int maxArea = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        simulationLab = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                lab[i][j] = val;
                simulationLab[i][j] = val;
            }
        }

        dfs(0);

        System.out.println(maxArea);

    }

    public static void dfs(int cnt) { // 3개의 벽 세우기
        if (cnt == 3) {

            bfs();
            reset();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] != 0) continue;
                lab[i][j] = 1;
                simulationLab[i][j] = 1;
                dfs(cnt + 1);
                lab[i][j] = 0;
                simulationLab[i][j] = 0;
            }
        }
    }

    public static void bfs() { // 바이러스 퍼트리기

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 2 && !visited[i][j]) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] temp = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nextY = temp[0] + dy[k];
                            int nextX = temp[1] + dx[k];

                            if (isRange(nextY, nextX)) {
                                if (lab[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                                    visited[nextY][nextX] = true;
                                    lab[nextY][nextX] = 2;
                                    q.offer(new int[]{nextY, nextX});
                                }
                            }
                        }
                    }
                }
            }
        }


        getSafetyZone();
        visited = new boolean[N][M];


    }

    public static void getSafetyZone() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) cnt += 1;
            }
        }

        maxArea = Math.max(cnt, maxArea);
    }


    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= M);
    }

    public static void reset() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = simulationLab[i][j];
                lab[i][j] = val;
            }
        }

    }
}
