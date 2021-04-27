import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] board;
    static int wcnt, bcnt = 0;
    public static void main(String[] args) throws IOException {

        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];


        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        split(0, 0, N);

    }

    public static void split(int x, int y, int N) {
        int cnt = 0;
        for(int i = x; i < x+N; i++) {
            for(int j = y; j < y+N; j++) {
                if(board[i][j] == 1) cnt++;
            }
        }

        if(cnt == N * N) bcnt++;
        if(cnt == 0) wcnt++;
        
        
    }
}
