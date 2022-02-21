import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // vertex, u
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
        }

        dfs(1);

        while(true) {
            int chRes = check_visited();
            if(chRes == -1) break;
            else {
                dfs(chRes);
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int start) {
        for (int j = 0; j < graph.get(start).size(); j++) {
            int temp = graph.get(start).get(j);
            if(!visited[temp]) {
                visited[temp] = true;
                dfs(temp);
            }
        }
    }

    public static int check_visited() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt += 1;
                return i;
            }
        }
        return -1;
    }




}
