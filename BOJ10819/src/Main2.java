import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : PACKAGE_NAME
 * fileName       : Main2
 * author         : home
 * date           : 22. 10. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 10. 21.        home       최초 생성
 */
public class Main2 {

    static int N;
    static int[] seq;
    static boolean[] visited;
    static int[] newSeq;

    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        seq = new int[N];
        newSeq = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int cnt) {
        if (cnt == N) {
            result = Math.max(getSum(newSeq), result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            newSeq[cnt] = seq[i];
            dfs(cnt + 1);
            visited[i] = false;
        }
    }

    public static int getSum(int[] arr) {

        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }
}
