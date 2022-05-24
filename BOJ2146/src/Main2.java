import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  shinmj
 * date : 22. 10. 12.
 * description : 복습, 메모리가 1.5배나 많아져벌인...
 */
public class Main2 {

    static int N;
    static int[][] nation;
    static boolean[][] visited;


    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static Queue<int[]> q = new LinkedList<>();

    static int numbering = 1;

    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        nation = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 일단 각 지역마다 번호를 통일 시켜줘야 될거같은데...
        // bfs가 나을까 dfs가 나을까..


        // numbering
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nation[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    numbering++;
                }
            }
        }
        // dfs로 해봤는데 bfs가 더 빠르다..

        reset();

        // 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nation[i][j] != 0 && !visited[i][j]) {

                    bfs(i, j, nation[i][j]);
                    reset();

                }
            }
        }

        System.out.println(minDist);
    }

    public static void bfs(int y, int x, int number) { // 비교할 지역 숫자
        q.offer(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];
                int curCnt = temp[2];

                if (isRange(nextY, nextX) && !visited[nextY][nextX]) {
                    if (nation[nextY][nextX] == 0) { // 0이면 지나가야되지 않나
                        visited[nextY][nextX] = true;
                        q.offer(new int[]{nextY, nextX, curCnt + 1});
                    }else if(nation[nextY][nextX] != number) {
                        //만약 숫자 다르면 갱신
                        minDist = Math.min(curCnt, minDist);
                        q.clear();
                        return;
                    }
                }
            }
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        nation[y][x] = numbering;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isRange(nextY, nextX) && !visited[nextY][nextX]) {
                if (nation[nextY][nextX] == 1) {
                    dfs(nextY, nextX);
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= N);
    }

    public static void reset() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }
}
