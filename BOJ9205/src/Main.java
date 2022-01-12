import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()) ; // 테스트 케이스 개수

        ArrayList<Point> points;
        ArrayList<ArrayList<Integer>> graph;

        while(T-- > 0) {
            int n = 0; // 편의점 개수

            n = Integer.parseInt(br.readLine());


            points = new ArrayList<>();
            graph = new ArrayList<>();
            StringTokenizer st;
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for(int j = i + 1; j < n + 2; j++) {
                    if(getDistance(points.get(i), points.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            System.out.print(BFS(graph, n) ? "happy" : "sad");

        }
    }

    public static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[N + 2];
        visited[0] = true;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(now == N + 1) return true;

            for(int next : graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }
}




class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
