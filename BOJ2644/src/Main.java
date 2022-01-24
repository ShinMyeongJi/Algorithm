import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int parent, child;
    static ArrayList<ArrayList<Integer>> relations;
    static boolean[] visited;
    static int res = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];


        StringTokenizer st = new StringTokenizer(br.readLine());

        parent = Integer.parseInt(st.nextToken());
        child = Integer.parseInt(st.nextToken());


        m = Integer.parseInt(br.readLine());

        relations = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            relations.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());

            relations.get(person1).add(person2);
            relations.get(person2).add(person1);

        }

        dfs(parent, child, 0);
        System.out.println(res);
    }

    public static void dfs(int start, int end, int cnt) {
        if(start == end) {
            res = cnt;
            return;
        }

        visited[start] = true;
        for (int i = 0; i < relations.get(start).size(); i++) {
            int nextP = relations.get(start).get(i);
            if(!visited[nextP]) {
                dfs(nextP, end, ++cnt);
            }
        }
    }
}
