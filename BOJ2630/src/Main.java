import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        int[][] board = new int[N][N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
