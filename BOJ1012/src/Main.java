import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    public static void main(String[] args) throws IOException {
        int reCnt = 0;
        int K;

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        reCnt = Integer.parseInt(br.readLine());

        for(int r = 0; r < reCnt; r++) {
            int cntBug = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 가로 col
            N = Integer.parseInt(st.nextToken()); // 세로 row
            K = Integer.parseInt(st.nextToken());

            int[][] field = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken()); // 가로
                int row = Integer.parseInt(st.nextToken()); // 세로

                field[row][col] = 1;
            }

            Queue<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (field[j][k] == 1 && !visited[j][k]) {
                        q.offer(new int[]{j, k});

                        while(!q.isEmpty()) {
                            int[] started = q.poll();

                            for (int l = 0; l < 4; l++) {
                                int nextRow = started[0] + dy[l];
                                int nextCol = started[1] + dx[l];

                                //bfs
                                if(isRange(nextRow, nextCol) && field[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                                    visited[nextRow][nextCol] = true;
                                    q.offer(new int[]{nextRow, nextCol});
                                }

                            }

                        }
                        cntBug += 1;
                    }

                }
            }
            System.out.println(cntBug);
        }
    }

    public static boolean isRange(int row, int col) {
        if (row >= 0 && row < N && col >=0 && col < M) {
            return true;
        }
        return false;
    }
}