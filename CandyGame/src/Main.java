import java.util.Scanner;

public class Main {
    public static int N;
    public static char[][] board;
    public static int max = 0;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        board = new char[N][N];

        for(int i = 0; i < N; i++) {
            String record = kb.next();
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = record.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++) {
                swap(board[i][j], board[i][j+1]);

                arrCheck();

                swap(board[i][j+1], board[i][j]);
            }
        }


        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N; j++) {
                swap(board[i][j], board[i+1][j]);

                arrCheck();

                swap(board[i+1][j], board[i][j]);
            }
        }


        System.out.println(max);
    }

    public static void swap(char a, char b) {
        char temp = a;
        a = b;
        b = temp;
    }

    public static void arrCheck() {
        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 0; j < N-1; j++) {
                if(board[i][j] == board[i][j+1]){
                    count++;
                }else{
                    count = 1;
                }

                max = Math.max(count, max);

            }
        }


        for(int i = 0; i < N-1; i++) {
            int count = 1;
            for(int j = 0; j < N; j++) {
                if(board[i][j] == board[i+1][j]){
                    count++;
                }else{
                    count = 1;
                }

                max = Math.max(count, max);
            }
        }

    }
}
