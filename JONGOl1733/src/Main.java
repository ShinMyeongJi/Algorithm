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
                if(board[i][j] == 1 || board[i][j] == 2) {

                    checkOmok(i , j);
                }
            }
        }
    }

    public static void checkOmok(int i, int j) {
        int num = board[i][j];
        int ori_i = i, ori_j = j;
        int cnt = 0;
        //오른쪽
        for(int li = 0; li < 5; li++, j++) {
            if(cnt == 4) {
                if (ori_i != 0 || ori_j != 0 || ori_i != 18 || ori_j != 18) {
                    if(board[ori_i][ori_j-1] == num || board[i][j+1] == num){
                        cnt = 0;
                        break;
                    }else{
                        System.out.println(num);
                        System.out.println((ori_i+1) + " " + (ori_j+1));
                        return;
                    }
                }
            }
            if(num != board[i][j+1]) {
                cnt = 0;
                break;
            }

            cnt++;
        }


        //오른쪽 아래
        for(int li = 0; li < 5; li++, i++, j++) {
            if(cnt == 4) {
                if (ori_i != 0 || ori_j != 0 || ori_i != 18 || ori_j != 18) {
                    if(board[ori_i-1][ori_j-1] == num || board[i+1][j+1] == num){
                        cnt = 0;
                        break;
                    }else{
                        System.out.println(num);
                        System.out.println((ori_i+1) + " " + (ori_j+1));
                        cnt = 0;
                        return;
                    }
                }
            }
            if(num != board[i+1][j+1]) {

                cnt = 0;
                break;
            }
            cnt++;
        }


        //오른쪽 위
        for(int li = 0; li < 5; li++, i--, j++) {

            if(cnt == 4) {
                System.out.println(i + "," + j);
            }

            if(num != board[i-1][j+1]){
                cnt = 0;
                break;
            }

            cnt++;
            if(cnt == 4) {
                if (ori_i != 0 || ori_j != 0 || ori_i != 18 || ori_j != 18) {

                    if(board[ori_i+1][ori_j-1] == num || board[i-1][j+1] == num){
                        cnt = 0;
                        break;
                    }else{
                        System.out.println(num);
                        System.out.println((ori_i+1) + " " + (ori_j+1));
                        return;
                    }
                }
            }
            if(num != board[i-1][j+1]) {
                cnt = 0;
                break;
            }

            cnt++;
        }

        //아래
        for(int li = 0; li < 5; li++, i++) {
            if(cnt == 4) {
                if (ori_i != 0 || ori_j != 0 || ori_i != 18 || ori_j != 18) {
                    if(board[ori_i-1][ori_j] == num || board[i+1][j] == num){
                        cnt = 0;
                        break;
                    }else{
                        System.out.println(num);
                        System.out.println((ori_i+1) + " " + (ori_j+1));
                        cnt = 0;
                        return;
                    }
                }
            }
            if(num != board[i+1][j]) {
                cnt = 0;
                break;
            }
            cnt++;
        }
    }
}
