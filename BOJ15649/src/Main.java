import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백트래킹 연습
 * 개념 및 DFS 비교 (정리) - https://holistic-rib-bd8.notion.site/DFS-BFS-94b7129f7d5d481fb4358a438758bd75
 */
public class Main {


    static int N = 0;
    static int M = 0;
    static boolean[] visited;
    static int[] res;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        res = new int[M];

        backtracking(0);

    }

    public static void backtracking(int cnt) {
        if(cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[cnt] = i+1;
                backtracking(cnt + 1);
                visited[i] = false;
            }
        }
    }

}
