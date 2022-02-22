import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int reCnt = 0;
        int M, N, K;

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int r = 0; r < reCnt; r++) {

            reCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken());

            int[][] field = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken()); // 가로
                int row = Integer.parseInt(st.nextToken()); // 세로

                field[row][col] = 1;
            }

            Queue<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (field[j][k] == 1) {
                        q.offer(new int[]{j, k});

                        while(!q.isEmpty()) {
                            int[] started = q.poll();

                            for (int l = 0; l < 4; l++) {
                                int nextRow = started[0];
                                int nextCol = started[1];

                                //bfs
                            }

                        }
                    }
                }
            }



        }
    }
}
