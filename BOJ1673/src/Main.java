import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * EOF 다루는 문제
 * StringTokenizer로 EOF를 처리할 수 없음
 * BOJ 1673
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int n, k = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            String input = br.readLine();
            if(input == null) return;
            String[] inptus = input.split(" ");
            n = Integer.parseInt(inptus[0]);
            k = Integer.parseInt(inptus[1]);

            coupon(n, k, n);
        }
    }

    public static void coupon(int n, int k, int cnt) {
        if(n / k == 0) {
            System.out.println(cnt);
            return;
        }
        cnt += n/k;
        coupon((n / k) + (n % k), k, cnt);
    }
}
