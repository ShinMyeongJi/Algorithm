import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  home
 * date : 22. 10. 13.
 * description :
 */
public class Main {

    static int resMax = Integer.MIN_VALUE;
    static int[] cards;
    static boolean[] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0, 0);


        System.out.println(resMax);
    }


    public static void backtracking(int cnt, int val, int sum) {

        sum = sum + val;

        if (cnt == 3) {
            if (sum <= M) {
                resMax = Math.max(sum, resMax);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            backtracking(cnt + 1, cards[i], sum);
            visited[i] = false;
        }
    }
}
