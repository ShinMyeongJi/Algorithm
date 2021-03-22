import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper = new int[101][101];
    static boolean[][] isVisit = new boolean[101][101];

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int round = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        //입력부
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int r = x; r < x + 10; r++) {
                for (int c = y; c < y + 10; c++) {
                    paper[r][c] = 1;
                }
            }
        }

        //둘레 확인
        /* 1. 탐색하다가 1 만나면, 사방탐색
         * 2. 0인 공간 둘레 ++
         *
         */

        for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper.length; j++) {
                if(paper[i][j] == 1 && !isVisit[i][j]) {
                    bfs(i,j);
                }
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(round + "");

        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {i,j});
        isVisit[i][j] = true;

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.poll()[1];
            ;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위 밖 -> 아웃
                if(!(0<= nx && nx < 101 && 0 <= ny && ny < 101)) continue;

                // 인접값이 0이면 체크, 꺾인 부분은 중복 체크 되도록 방문처리 안함
                if(paper[nx][ny] == 0) round++;

                // 다음 값이 탐색 대상(1) 이고, 미방문이면 Q에 넣고 방문처리
                if(paper[nx][ny] == 1 && !isVisit[nx][ny]) {
                    isVisit[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}