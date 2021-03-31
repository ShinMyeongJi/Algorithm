import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        String[] random = new String[N];
        int[] strike = new int[N];
        int[] balls = new int[N];

        int[] curTempNum = new int[3]; // 현재 임의의 세자리 숫자
        int[] inputNums = new int[3]; // 입력들어온 세자리 숫자

        int curStrike = 0;
        int curBalls = 0;

        int cnt = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            random[i] = st.nextToken().trim();
            strike[i] = Integer.parseInt(st.nextToken().trim());
            balls[i] = Integer.parseInt(st.nextToken().trim());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                for(int k = 0; k < 9; k++) {
                    if(i != j && j != k && i != k) {
                        curTempNum[0] = i; curTempNum[1] = j;curTempNum[2] = k;
                        for(int l = 0; l < N; l++) {
                            inputNums[0] = Integer.parseInt(String.valueOf(random[l].charAt(0)));
                            inputNums[1] = Integer.parseInt(String.valueOf(random[l].charAt(1)));
                            inputNums[2] = Integer.parseInt(String.valueOf(random[l].charAt(2)));

                            for(int q = 0; q < 3; q++) {
                                for(int w = 0; w < 3; w++) {
                                    if(curTempNum[q] == inputNums[w]) {
                                        if(q == w) curStrike++;
                                        else curBalls++;
                                    }
                                }
                            }
                            if(curStrike == strike[l] && curBalls == balls[l]) cnt++;
                            curStrike = 0;
                            curBalls = 0;
                        }
                        if(N == cnt) min ++;
                        cnt = 0;
                    }
                }
            }
        }
        System.out.println(min);


    }
}
