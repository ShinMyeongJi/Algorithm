import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : PACKAGE_NAME
 * fileName       : Main2
 * author         : home
 * date           : 22. 10. 23.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 10. 23.        home       최초 생성
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V, E;
        int start;

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(d, v));
        }

        dist[start] = 0;
        for (int i = 0; i < V; i++) {
            int minNode = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && minNode > dist[j]) {
                    minNode = dist[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < graph.get(minIndex).size(); j++) {
                Node nNode = graph.get(minIndex).get(j);

                dist[nNode.des] = Math.min(dist[nNode.des], nNode.val + dist[minIndex]);
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }else System.out.println(dist[i]);
        }
    }
}

class Node {
    int des, val;

    Node(int des, int val) {
        this.des = des;
        this.val = val;
    }
}