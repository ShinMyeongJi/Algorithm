import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static char[][] board;
    public static char[][] trans;
    public static char[][] white =
            {
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
            };

    public static char[][] black =
            {
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                    {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                    {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
            };

    private static int change(int start, int end, int min) {
        int wht_min = 0;
        int blk_min = 0;

        int k = 0;
        StringBuilder builder = new StringBuilder("");
        for(int i = start; i < start + 8; i++){
            builder.setLength(0);
            for(int j = end; j < end + 8; j++) {
                builder.append(board[i][j]);
            }
            for(int j = 0; j < builder.length(); j++) {
                trans[k][j] = builder.charAt(j);
            }
            k++;
        }


        for(int i = 0; i < trans.length; i++){
            for(int j = 0; j < trans[0].length; j++){
                if(trans[i][j] != white[i][j]) wht_min++;
                if(trans[i][j] != black[i][j]) blk_min++;
            }
        }


        return Math.min(Math.min(wht_min, blk_min), min);
    }

    public static void main(String[] args) throws IOException {
        int N, Y;

        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        Y = kb.nextInt();

        board = new char[N][Y];
        trans = new char[8][8];
        for(int i = 0; i < N; i++){
            String str = kb.next();
            for(int j = 0; j < Y; j++) {
                board[i][j] = str.charAt(j);
            }
        }


        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= Y-8; j++) {
                min = change(i, j, min);

            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(min + "");

        bw.flush();
        bw.close();
    }
}
