import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //int[] arr;
        //boolean[] visited;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    find(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    public static void find(int idx) {
        visited[idx] = true;
        if (!visited[arr[idx]]) find(arr[idx]);
        else return;
    }

}
