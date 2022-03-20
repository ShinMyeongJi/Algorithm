import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] ocean;
    static int[][] meltCnt;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int year = 0;

    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ocean = new int[N][M];
        meltCnt = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true) {
            int cnt = 0;

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ocean[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                System.out.println(0);
                break;
            }else if (cnt >= 2) {
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }
    }


    public static void bfs(int y, int x) {
        q.offer(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX)) {

                    if (ocean[nextY][nextX] == 0) meltCnt[temp[0]][temp[1]]++;

                    if (ocean[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        q.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < M) return true;
        return false;
    }

    public static void melting() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ocean[i][j] -= meltCnt[i][j];

                if (ocean[i][j] < 0) ocean[i][j] = 0;

                visited[i][j] = false;
                meltCnt[i][j] = 0;
            }
        }
    }
}

/*

// 시간초과 된 코드

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] ocean;
    static int[][] meltCnt;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int year = 0;

    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ocean = new int[N][M];
        meltCnt = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true) {
            year++;
            int cnt = 0;

            oneYearLater();

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ocean[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                        cnt++;
                    }
                }

                if (cnt >= 2) {
                    System.out.println(year);
                    return;
                }
            }


            for (int i = 0; i < visited.length; i++) {
                Arrays.fill(visited[i], false);
            }
        }
    }

    public static void oneYearLater() {
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (ocean[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];

                        if(isRange(nextY, nextX) && ocean[nextY][nextX] == 0)
                            meltCnt[i][j] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ocean[i][j] = ocean[i][j] - meltCnt[i][j];
                if(ocean[i][j] < 0) ocean[i][j] = 0;
            }
        }
        for (int i = 0; i < meltCnt.length; i++) {
            Arrays.fill(meltCnt[i], 0);
        }
    }

    public static void bfs(int y, int x) {
        q.offer(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX) && ocean[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    q.offer(new int[]{nextY, nextX});
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < M) return true;
        return false;
    }
}
*/
