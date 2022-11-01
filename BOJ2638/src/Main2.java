import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
 */
public class Main2 {
    static int N,M;
    static int[][] paper;
    static int[][] paperCopy;

    static boolean[][] visited;


    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int hour = 0;
    static int cheeseCnt = 0;

    static int numbering = 1;
    static int lastCheese;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        paperCopy = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) cheeseCnt++;
            }
        }


        while (true) {
            lastCheese = 0;
            visited = new boolean[N][M];
            changeExternalAir();
            numbering++;
            visited = new boolean[N][M];
            //print();

            for (int i = 0; i < N; i++) {
                for (int j = 0 ; j < M; j++) {
                    if (!visited[i][j] && paper[i][j] == 1) {
                        meltingCheese(i, j);
                    }
                }
            }

            melting();

            hour++;

            if (cheeseCnt == 0) {
                break;
            }
        }


        System.out.println(hour);
        System.out.println(lastCheese);

    }

    // 먼저 외부 공기를 바꾼다.(0 -> 3)
    public static void changeExternalAir() {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX) && !visited[nextY][nextX]) {
                    if (paper[nextY][nextX] == 0 || paper[nextY][nextX] == 3) {
                        visited[nextY][nextX] = true;
                        paper[nextY][nextX] = 3;
                        q.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }

    public static void meltingCheese(int startY, int startX) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY, startX});



        while (!q.isEmpty()) {
            int[] temp = q.poll();

            visited[temp[0]][temp[1]] = true;

            if(isMelted(temp[0], temp[1])) {
                paperCopy[temp[0]][temp[1]] = numbering; // 녹을 치즈를 표시해준다.
                lastCheese++;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX) && paper[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                        q.offer(new int[]{nextY, nextX});
                }
            }
        }
    }

    // 녹는 치즈 표시
    public static boolean isMelted(int y, int x) {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (isRange(nextY, nextX)) {
                if (paper[nextY][nextX] == 3) { // 외부 공기랑 맞닿아있다면
                    cnt++;
                }
            }
            if (cnt == 2) break;

        }
        return cnt >= 2;
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= M);
    }

    /*public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(paper[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("=================================");
    }*/
    public static void melting() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paperCopy[i][j] == numbering) {
                    paper[i][j] = 3;
                    cheeseCnt--;
                }
            }
        }
    }
}