import com.sun.javaws.IconUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main {
    public static final int SIZE = 19;
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        board = new int[SIZE][SIZE];

        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(bw.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(board[i][j] == 1 || board[i][j] == 2) checkOmok(i , j);
            }

        }
    }

    public static void checkOmok(int i, int j) {
        int num = board[i][j];

        //오른쪽
        for(int li = 0; li < 4; li++, j++) {
            //System.out.print(board[i][j+1]);
            if(num != board[i][j+1]) break;
        }
        //System.out.println();

        //오른쪽 아래
        for(int li = 0; li < 5; li++, i++, j++) {
            System.out.print(board[i+1][j+1]);
            if(num != board[i+1][j+1]) break;
        }
        System.out.println();

        //오른쪽 위
        for(int li = 0; li < 5; li++, i++, j++) {
            System.out.print(board[i-1][j+1]);
            if(num != board[i-1][j+1]) break;
        }

        //아래
        for(int li = 0; li < 5; li++, i++, j++) {
            System.out.print(board[i+1][j]);
            if(num != board[i+1][j]) break;
        }

    }
}
