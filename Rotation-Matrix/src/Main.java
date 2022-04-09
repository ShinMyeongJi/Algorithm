import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotation90Matrix();
        rotation180Matrix();
    }

    // y -> N-1-i, x->j
    public static void rotation90Matrix() {
        int[][] newMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMatrix[j][N - 1 - i] = matrix[i][j];
            }
        }

        System.out.println("======90 rotation======");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // y -> N-1-i, x -> N-1-j
    public static void rotation180Matrix() {
        int[][] newMatrix = new int[N][N];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMatrix[N-1-i][N-1-j] = matrix[i][j];
            }
        }

        System.out.println("======180 rotation======");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
