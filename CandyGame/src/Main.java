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

        // 가로
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++) {
                //swap(board[i][j], board[i][j+1]);
                char temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;

                arrCheck();

                //swap(board[i][j], board[i][j+1]);

                temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;
            }
        }


        for(int i = 0; i < N; i++){
            for(int j = 0; j < N-1; j++) {
                //swap(board[j][i], board[j+1][i]);

                char temp = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = temp;


                arrCheck();

                //swap(board[j][i], board[j+1][i]);

                temp = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = temp;
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
                max = Math.max(max, count);

            }
        }


        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 0; j < N-1; j++) {
                if(board[j][i] == board[j+1][i]){
                    count++;
                }else{
                    count = 1;
                }

                max = Math.max(max, count);
            }
        }

    }
}
