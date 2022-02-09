import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp(N);
        System.out.println(cnt);
    }

    static void dp(int N) {
        /*if(N == 0) {
            System.out.println(cnt);
            return;
        }

        cnt += 1;

        if(N - 1 > 0 && N - 1 < N) dp(N - 1);
        if(N - 2 > 0 && N - 2 < N) dp(N - 2);
        if(N - 3 > 0 && N - 3 < N) dp(N - 3);*/

        if(N < 0) return;
        else if(N == 0) {
            cnt++;
            return;
        }else {
            for (int i = 1; i <= 3; i++) {
                dp(N - i);
            }
        }
    }
}
