import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * JONGOL 1733
 */

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

                    if(checkOmok(i , j)) return;

                }
            }
        }
        System.out.println(0);
    }

    public static boolean checkOmok(int i, int j) {
        int num = board[i][j];
        int ori_i = i, ori_j = j;
        int cnt = 1;

        //오른쪽
        for(int li = 1; li <= 4; li++) {
            if(i > 18 || i < 1 || j + li >= 18 || j + li <= 1) break;
            if(num == board[i][j+li]) {

                cnt++;
            }else{
                cnt = 1;
                break;
            }

            if(cnt == 5){
                if(num != board[i][j + li + 1] && num != board[i][j - 1]){

                    System.out.println(num);
                    System.out.println((ori_i+1) + " " + (ori_j+1));
                    return true;
                }
            }
        }


        //오른쪽 아래
        for(int li = 1; li <= 4; li++) {
            if(i + li + 1 >= 18 || i + li +1 <= 1 || j + li >= 18 || j + li <= 1) break;
            if(num == board[i+li][j+li]) {

                cnt++;
            }else{
                cnt = 1;
                break;
            }

            if(cnt == 5){
                if(num != board[i + li + 1][j + li + 1] && num != board[i - 1][j - 1]){

                    System.out.println(num);
                    System.out.println((ori_i+1) + " " + (ori_j+1));
                    return true;
                }
            }
        }


        //오른쪽 위
        for(int li = 1; li <= 4; li++) {
            if(i - li >= 18 || i - li <= 1 || j + li >= 18 || j + li <= 1) break;
            if(num == board[i-li][j+li]) {
                cnt++;
            }else{
                cnt = 1;
                break;
            }

            if(cnt == 5){
                if(num != board[i - li - 1][j + li + 1] && num != board[i + 1][j - 1]){

                    System.out.println(num);
                    System.out.println((ori_i+1) + " " + (ori_j+1));
                    return true;
                }
            }
        }



        return false;


    }
}
