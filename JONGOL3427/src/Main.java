import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] balls = new int[N];
        String strBalls = br.readLine();
        for(int i = 0; i < N; i++) {
            balls[i] = strBalls.charAt(i);
        }


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {

            }
        }
    }
}
