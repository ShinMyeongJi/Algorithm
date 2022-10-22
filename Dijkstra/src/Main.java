import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : PACKAGE_NAME
 * fileName       : Main
 * author         : home
 * date           : 22. 10. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 10. 22.        home       최초 생성
 */


/**
6 7
1
1 2 2
1 4 1
2 4 2
2 3 3
3 6 5
4 5 1
5 6 2
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V, E; // 노드와 간선의 개수
        int start; // 시작 지점


        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();


        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());

            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int v = Integer.parseInt(st.nextToken());

            graph.get(point).add(new Node(d, v));
        }

        dist[start] = 0;

        for (int i = 1; i <= V; i++) {

            int minNode = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int j = 1; j < V + 1; j++) {
                if (!visited[j] && dist[j] < minNode) {
                    minNode = dist[j]; // 시작 노드를 정하는 것
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            int vLen = graph.get(minIndex).size();

            for (int j = 0; j < vLen; j++) {
                Node nNode = graph.get(minIndex).get(j);

                dist[nNode.d] = Math.min(dist[nNode.d], nNode.v + dist[minIndex]);
            }
        }

        System.out.println(dist[V]);
    }
}


class Node {
    int d, v; // destination과 가중치

    Node(int d, int v) {
        this.d = d;
        this.v = v;

    }
}