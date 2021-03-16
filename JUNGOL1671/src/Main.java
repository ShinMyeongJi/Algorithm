import java.util.Scanner;

/**
 * JONGOL 1671
 */
public class Main {
    private static final int SIZE = 111;
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        int[][] interval = new int[N][2];

        int[][] points = new int[SIZE][SIZE];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2; j++) {
                interval[i][j] = kb.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for(int j = interval[i][0]; j < interval[i][0] + 10; j++) {
                for(int k = interval[i][1]; k < interval[i][1] + 10; k++) {
                    points[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i < 100; i++) {
            for(int j = 1; j < 100; j++) {
                if(points[i][j] == 1) {
                    if(points[i + 1][j] == 0) cnt++;
                    if(points[i][j + 1] == 0) cnt++;
                    if(points[i - 1][j] == 0) cnt++;
                    if(points[i][j - 1] == 0) cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
