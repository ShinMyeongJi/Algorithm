import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] graph;

    public static void main(String[] args) throws IOException {
        int M, N, start;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
            graph[0][i] = Integer.parseInt(st.nextToken());
            graph[1][i] = Integer.parseInt(st.nextToken());
        }




        dfs(start);
    }

    public static void dfs(int start) {

    }
}
