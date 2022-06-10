import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName    : PACKAGE_NAME
 * fileName       : Main
 * author         : shinmj
 * date           : 2022-10-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-17        shinmj       최초 생성
 */
public class Main {
    // 3은 외부 공간
    // 4는 곧 녹을 새끼
    // 0은 내부 공간
    // 1은 치즈
    static int N,M;
    static int[][] paper;
    static boolean[][] meltedCheese;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int hour;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        meltedCheese = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*bfs();


        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(paper[i][j] + " ");
            }
            System.out.println();
        }*/

        simulation();

        System.out.println(hour);
    }

    // 치즈 내외부 체크
    public static void bfs() {
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(0, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = p.y + dy[i];
                int nextX = p.x + dx[i];

                if (isRange(nextY, nextX)) {
                    if (paper[nextY][nextX] == 0 || paper[nextY][nextX] == 3) {
                        paper[nextY][nextX] = 3;
                        q.offer(new Point(nextY, nextX));
                    }
                }
            }
        }

    }

    public static void simulation() {

        boolean isBin = false;
        for (int i = 0; i < N; i++) {
            Arrays.fill(meltedCheese[i], false);
        }
        while (true) {
            bfs();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (paper[i][j] == 1) {
                        if (isMelted(i, j)) {
                            isBin = true;
                            //paper[i][j] = 3;
                            meltedCheese[i][j] = true;
                        }
                    }
                }
            }

            hour++;
            melting();

            if (!isBin) break;
            else isBin = false;
        }
    }

    public static boolean isMelted(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (paper[nextY][nextX] == 3) cnt++;
        }

        return cnt >= 2;
    }

    public static void melting() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (meltedCheese[i][j]) paper[i][j] = 3;
            }
        }
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= M);
    }

    static class Point {
        int y, x;
        //int time;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
            //this.time = time;
        }


    }


}
