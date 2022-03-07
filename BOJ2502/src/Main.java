import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int D, K; // D 할머니가 넘어온 날, K 호랑이한테 준 떡
        int X = 0, Y = 0; // A = day1 떡 개수, B = day2 떡 개
        int res;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] coeX = new int[D + 1]; // x의 계수
        int[] coeY = new int[D + 1]; // y의 계수

        //계수
        coeX[1] = 1;
        coeY[1] = 0;
        coeX[2] = 0;
        coeY[2] = 1;

        for (int i = 3; i < coeX.length; i++) {
            coeX[i] = coeY[i-1];
            coeY[i] = coeX[i-1] + coeY[i-1];
        }


        while(true) {
            res = 0;
            res = X * coeX[D];

            while(true) {
                res += Y * coeY[D];

                if (res == K) {
                    System.out.println(X);
                    System.out.println(Y);
                    return;
                }

                if (res > K) {
                    Y = 0;
                    break;
                }

                res -= Y * coeY[D];
                Y++;
            }
            X++;
        }
    }

    /** // 예전에 푼거 보니까 이렇게 풀었네..
     * public static int fibo(int n) {
     *     int next = 1;
     *     int term1 = 1, term2 = 1;
     *
     *     if(n == 1 || n == 2) return next;
     *
     *     for(int i = 1; i < n - 1; i++) {
     *         next = term1 + term2;
     *         term1 = term2;
     *         term2 = next;
     *     }
     *
     *     return next;
     * }
     */
}
