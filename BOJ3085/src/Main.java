import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] board;
    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j + 1 < N) {
                    //swapHor(i, j);

                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    res = Math.max(check(), res);

                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    //swapHor(i, j);
                }

                if (i + 1 < N) {
                    //swapVer(i, j);

                    char temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;

                    res = Math.max(check(), res);

                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;

                    //swapVer(i, j);
                }
            }
        }

        System.out.println(res);
    }

    // 세로로 교환
    /*public static void swapVer(int i, int j) {
        char temp = board[i][j];
        board[i][j] = board[i + 1][j];
        board[i + 1][j] = board[i][j];
    }*/

    // 가로로 교환
    /*public static void swapHor(int i, int j) {
        char temp = board[i][j];
        board[i][j] = board[i][j + 1];
        board[i][j + 1] = temp;
    }*/

    public static int check() {
        int ans = 1;

        // 가로 열 비교
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) cnt++;
                else cnt = 1;

                ans = Math.max(ans, cnt);
            }
        }

        // 세로 행 비교
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (board[j][i] == board[j - 1][i]) cnt++;
                else cnt = 1;

                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}
