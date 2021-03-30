import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean statSwitch = false;
    public static int cnt = 0;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] balls = new int[N];
        String strBalls = br.readLine();


        //R를 왼쪽
        for(int i = 0; i < N; i++) {
            if(strBalls.charAt(i) == 'B') statSwitch = true;
            if(statSwitch && strBalls.charAt(i) == 'R') cnt++;
        }
        reset();

        for(int i = N - 1; i >= 0; i--) {
            if(strBalls.charAt(i) == 'B') statSwitch = true;
            if(statSwitch && strBalls.charAt(i) == 'R') cnt++;
        }
        reset();

        for(int i = 0; i < N; i++) {
            if(strBalls.charAt(i) == 'R') statSwitch = true;
            if(statSwitch && strBalls.charAt(i) == 'B') cnt++;
        }
        reset();

        for(int i = N - 1; i >= 0; i--) {
            if(strBalls.charAt(i) == 'R') statSwitch = true;
            if(statSwitch && strBalls.charAt(i) == 'B') cnt++;
        }
        reset();

        System.out.println(min);
    }

    public static void reset() {
        statSwitch = false;
        if(cnt < min) min = cnt;
        cnt = 0;
    }
}
