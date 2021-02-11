import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int N, Y;

        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        Y = kb.nextInt();

        char[][] board = new char[N][Y];

        for(int i = 0; i < N; i++){
            String str = kb.next();
            for(int j = 0; j < Y; j++) {
                board[i][j] = str.charAt(j);
            }
        }


        for(int i = 0; i < N; i++){
            for(int j = 0; j < Y; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
