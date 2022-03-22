import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 범위...!!!!! 제발 범위..!!!!!!1
 */
public class Main {

    static long A,B;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        dfs(A, 1);
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    public static void dfs(long res, int cnt) {
        if (res == B) {
            min = Math.min(min, cnt);
            return;
        }else if (res > B) {
            return;
        }

        dfs(res * 2, cnt + 1);
        dfs(res * 10 + 1, cnt + 1);
    }
}
