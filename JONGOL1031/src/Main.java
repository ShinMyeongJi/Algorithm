import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int SIZE = 5;
    public static int[][] board = new int[SIZE][SIZE];
    public static int[][] calledNums = new int[SIZE][SIZE];
    public static boolean[][] isVisited = new boolean[SIZE][SIZE];
    public static void main(String[] args) throws IOException {

        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(bw.readLine());
            for(int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < SIZE; i++) {
           st = new StringTokenizer(bw.readLine());
            for(int j = 0; j < SIZE; j++) {
                calledNums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                checkBingo(calledNums[i][j]);
            }
        }


    }

    public static void checkBingo(int calledNum) {
        int cur_i = 0;
        int cur_j = 0;
        for(int i = 0; i < SIZE; i++ ){
            for(int j = 0; j < SIZE; j++) {
                if(calledNum == board[i][j]) {
                    isVisited[i][j] = true;
                    cur_i = i;
                    cur_j = j;
                    break;
                }
            }
        }


        //현재 방문한 기준으로 가로, 세로, 좌우 대각선 빙고 확인

        //가로
        checkHor(cur_i, cur_j);
        //세로
        checkVer(cur_i, cur_j);
        //기울기 양의 대각선
        checkDiagPlus(cur_i, cur_j);
        //기울기 음의 대각선
        checkDiagMinus(cur_i, cur_j);


    }

    public static void checkHor(int cur_i, int cur_j) {
        int cnt = 0;
        for(int j = 0; j < cur_j; j++) {
            if(isVisited[cur_i][j])
            {
                cnt++;
            }
        }

        for(int j = SIZE -1; j > cur_j; j--) {
            if(isVisited[cur_i][j]){
                cnt++;
            }
        }

        System.out.print(cnt);

    }

    public static void checkVer(int cur_i, int cur_j){

    }

    public static void checkDiagPlus(int cur_i, int cur_j){

    }
    public static void checkDiagMinus(int cur_i, int cur_j){

    }
}
