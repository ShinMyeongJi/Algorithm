import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int SIZE = 5;
    public static int[][] board = new int[SIZE][SIZE];
    public static int[][] calledNums = new int[SIZE][SIZE];
    public static boolean[][] isVisited = new boolean[SIZE][SIZE];
    public static int called = 0;
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
                called++;
                if(checkBingo(calledNums[i][j]) && called >= 12){
                    System.out.println(called);
                    return;
                }
            }
        }


    }

    public static boolean checkBingo(int calledNum) {
        int bingo = 0;

        for(int i = 0; i < SIZE; i++ ){
            for(int j = 0; j < SIZE; j++) {
                if(calledNum == board[i][j]) {
                    isVisited[i][j] = true;
                    break;
                }
            }
        }


        //현재 방문한 기준으로 가로, 세로, 좌우 대각선 빙고 확인
        bingo = checkHor() + checkVer() + checkDiagPlus() + checkDiagMinus();

        if(bingo >= 3) return true;


        return false;
    }

    //가로
    public static int checkHor() {
        int numBingo = 0;

        for(int i = 0; i < SIZE; i++) {
            int cnt = 0;
            for(int j = 0; j < SIZE; j++) {
                if(isVisited[i][j])  ++cnt;
                if(cnt == 5) ++numBingo;
            }
        }

        return numBingo;
    }

    //세로
    public static int checkVer(){
        int numBingo = 0;

        for(int i = 0; i < SIZE; i++) {
            int cnt = 0;
            for(int j = 0; j < SIZE; j++) {
                if(isVisited[j][i])  ++cnt;
                if(cnt == 5) ++numBingo;
            }
        }

        return numBingo;
    }

    //기울기 : 양의 정수, 대각선
    public static int checkDiagPlus(){
        int numBingo = 0;
        int j = SIZE - 1;
        for(int i = 0; i < SIZE; i++) {
            if(isVisited[i][j--]) ++numBingo;
            if(numBingo == 5) return 1;
        }


        return 0;

    }

    //기울기 : 음의 정수, 대각선
    public static int checkDiagMinus(){
        int numBingo = 0;

        for(int i = 0; i < SIZE; i++) {
            if(isVisited[i][i]) ++numBingo;
            if(numBingo == 5) return 1;
        }

        return 0;
    }
}