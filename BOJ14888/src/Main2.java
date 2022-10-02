import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  home
 * date : 22. 10. 16.
 * description :
 */
public class Main2 {
    static int N;
    static int[] numbers;
    static int[] operations = new int[4];

    static int resMin = Integer.MAX_VALUE;
    static int resMax = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(resMax);
        System.out.println(resMin);
    }

    public static void dfs(int cnt, int res) {
        if (cnt == N) {
            resMax = Math.max(resMax, res);
            resMin = Math.min(resMin, res);

            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operations[i] > 0) {

                operations[i]--;

                switch (i) {
                    case 0 : {
                        dfs(cnt + 1, res + numbers[cnt]);
                        break;
                    }
                    case 1 :  {
                        dfs(cnt + 1, res - numbers[cnt]);
                        break;
                    }
                    case 2 : {
                        dfs(cnt + 1, res * numbers[cnt]);
                        break;
                    }
                    case 3 :  {
                        dfs(cnt + 1, res < 0 ? -1*((res*-1) / numbers[cnt]) : res / numbers[cnt]);
                        break;
                    }
                }

                operations[i]++;
            }
        }

    }
}
