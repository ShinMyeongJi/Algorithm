import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> pq = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int N, M, start;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        for(int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());

            graph.get(point1).add(point2);
            graph.get(point2).add(point1);
        }


        pq.offer(start);

        dfs(start);
        bfs();
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < graph.get(start).size(); i++) {
            if(!visited[graph.get(start).get(i)]) {
                dfs(graph.get(start).get(i));
            }
        }
    }

    public static void bfs() {

        while(!pq.isEmpty()) {

            int current = pq.poll();

            System.out.println(current);

            for (int i = 0; i < graph.get(current).size(); i++) {
                if (!visited[graph.get(current).get(i)]) {
                    visited[current] = true;
                    pq.add(graph.get(current).get(i));
                }
            }


        }
    }

}
