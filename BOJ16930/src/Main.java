import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 세로
    static int M; // 가로
    static int K;
    static char[][] gym;
    static int[][] times;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int startX, startY;
    static int desX, desY;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gym = new char[N + 1][M + 1];
        times = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                gym[i][j] = str.charAt(j - 1);
                times[i][j] = Integer.MAX_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());

        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        desY = Integer.parseInt(st.nextToken());
        desX = Integer.parseInt(st.nextToken());

        q.offer(new Node(startX, startY));
        times[startY][startX] = 0;

        bfs();
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.y == desY  && temp.x == desX) {
                System.out.println(times[desY][desX]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    int nextY = temp.y + (dy[i] * j);
                    int nextX = temp.x + (dx[i] * j);

                    if (isRange(nextY, nextX)) {
                        if (gym[nextY][nextX] == '.') {
                            if (times[nextY][nextX] > times[temp.y][temp.x] && times[nextY][nextX] == Integer.MAX_VALUE) {
                                times[nextY][nextX] = times[temp.y][temp.x] + 1;
                                q.offer(new Node(nextX, nextY));
                            }
                        }else break;
                    }
                }
            }
        }

        System.out.println(-1);
        return;
    }

    public static boolean isRange(int y, int x) {
        if(y >= 1 && y <= N && x >= 1 && x <= M) return true;
        return false;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
