import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N = 0;
    static boolean[][] visited;

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];




        for (int i = 0; i < N; i++) {
            backtracking(0, count);
        }

    }

    public static void backtracking(int col, int count) {
        if(count == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {

        }

    }

    public static boolean isPromising() {
        return true;
    }
}
