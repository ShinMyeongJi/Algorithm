import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : PACKAGE_NAME
 * fileName       : Main
 * author         : shinmj
 * date           : 22. 10. 23.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 10. 23.        shinmj       최초 생성
 */

/**
4 5
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
2 3
 */
public class Main {

    static int N, E;

    static int[] dist;
    static boolean[] visited;

    static ArrayList<ArrayList<Node>> graph;

    static final int INF = 114748360;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] mustVisit = new int[2];

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());

            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(d, v));
            graph.get(d).add(new Node(s, v));
        }

        st = new StringTokenizer(br.readLine());

        mustVisit[0] = Integer.parseInt(st.nextToken());
        mustVisit[1] = Integer.parseInt(st.nextToken());

        int anb = 0, bna = 0;

        anb += dijkstra(1, mustVisit[0]);
        anb += dijkstra(mustVisit[0], mustVisit[1]);
        anb += dijkstra(mustVisit[1], N);

        bna += dijkstra(1, mustVisit[1]);
        bna += dijkstra(mustVisit[1], mustVisit[0]);
        bna += dijkstra(mustVisit[0], N);

        System.out.println((anb >= INF && bna >= INF) ? -1 : Math.min(anb, bna));
    }

    public static int dijkstra(int start, int end) {

        dist[start] = 0;

        for (int i = 0; i < N; i++){
            int minNode = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && minNode > dist[j]) {
                    minNode = dist[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            int vLen = graph.get(minIndex).size();
            for (int j = 0; j < vLen; j++) {
                Node nNode = graph.get(minIndex).get(j);
                dist[nNode.des] = Math.min(dist[nNode.des], dist[minIndex] + nNode.val);
            }
        }

        int minDist = dist[end];

        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);

        return minDist;
    }

}

class Node {
    int des, val;

    Node(int des, int val) {
        this.des = des;
        this.val = val;
    }
}