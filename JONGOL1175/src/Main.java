import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N = 0, M = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 횟수
        M = Integer.parseInt(br.readLine()); // 합

        print(0, 0);
    }

    public static void print(int sum, int cnt) { ;
        if(sum == M && cnt == N) {

        }

        for(int i = 1; i <= 6; i++) {
            print(sum + 1, cnt + 1);
        }
    }
}
