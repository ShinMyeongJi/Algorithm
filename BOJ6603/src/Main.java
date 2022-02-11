import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] lotto;
    static boolean[] visited;

    static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while(true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            lotto = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
                System.out.println(lotto[i]);
            }

            dfs(0, 1);
            System.out.println();
        }
    }

    static void dfs(int start, int cnt) {
        if(cnt == 7) {
            for (int i = 1; i <= N; i++) {
                if(visited[i]) System.out.print(lotto[i] + " ");
            }
            System.out.println();
        }

        for (int i = start + 1; i <= N; i++) {
            if(visited[i]) continue;
//            if(start != i && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
 //           }
        }
    }
}
