import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1759
 * 메모리 : 15416KB
 * 시간 : 140ms
 */
public class Main {
    private static int N;
    private static int C;
    private static char[] arr;
    private static boolean[] chk;
    private static char[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chk = new boolean[C];
        temp = new char[N];
        arr = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(arr);

        pick(0);
    }

    private static void pick(int step) {
        int vowelCnt = 0;

        if(step >= N) {
            for(int i = 0; i < N; i++){
                if(temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') vowelCnt++;
            }

            if(vowelCnt >= 1 && (N - vowelCnt) >= 2) {
                for (int i = 0; i < N; i++) {
                    System.out.print(temp[i]);
                }
                System.out.println();
            }

            return;
        }

        for(int i = 0; i < C; i++) {
            if(chk[i]) continue;

            if(step != 0) {
                if((int)temp[step-1] > (int)arr[i]) continue;
            }
            chk[i] = true;
            temp[step] = arr[i];
            pick(step + 1);
            chk[i] = false;
        }
    }
}
