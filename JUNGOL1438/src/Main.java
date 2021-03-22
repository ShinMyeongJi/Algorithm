import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * JONGOL 1438
 */
public class Main {

    private static final int SIZE = 100;
    public static void main(String[] args) throws IOException {

        int N = 0;

        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        int[][] test = new int[N][N];


        // 각 축들과의 간격
        int[][] interval = new int[N][2];

        // 유효 좌표
        int[][] points = new int[SIZE][SIZE];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(j == 0) {
                    test[i][0] = i + 1;
                }else{
                    test[i][j] = test[i][j-1] + N;
                }


            }
        }

        for(int i = 0; i < N; i++) {
            for(int j =0; j < N; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }



        /*for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                interval[i][j] = kb.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = interval[i][0]; j < interval[i][0] + 10; j++) {
                for(int k = interval[i][1]; k < interval[i][1] + 10; k++) {
                    points[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i  = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(points[i][j] == 1) cnt++;
            }
        }

        System.out.println(cnt);*/
    }
}
