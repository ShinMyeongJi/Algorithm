import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int SIZE = 19;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        board = new int[SIZE][SIZE];

        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer();

        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(bw.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        // 오른쪽
        // 오른쪽 아래
        // 위쪽
        // 오른쪽 위

        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(board[i][j] == 1 || board[i][2] == 2) checkOmok(board[i][j]);
            }

        }
    }

    public static void checkOmok(int dol) {

    }
}
