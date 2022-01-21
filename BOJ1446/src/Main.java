import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Point> list = new ArrayList<>();
        Dist[] dist = new Dist[D + 1];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(end > D || weight >= (end - start)) continue;
            list.add(new Point(start, end, weight));
        }


        PriorityQueue<Dist> pq = new PriorityQueue<>();

        for (int i = 0; i < dist.length; i++) {
            dist[i] = new Dist(i, Integer.MAX_VALUE);
            if(i == 0) {
                dist[0].dist = 0;
                pq.offer(dist[0]);
            }
        }


        while (!pq.isEmpty()) {
            Dist d = pq.poll();

            if(d.idx == D) break;

            Dist next = dist[d.idx + 1];
            if(next.dist >d.dist + 1) {
                next.dist = d.dist + 1;
                pq.offer(next);
            }

            for (Point p : list) {
                if(p.start == d.idx) {
                    Dist dNext = dist[p.end];
                    if(dNext.dist > d.dist + p.weight) {
                        dNext.dist = d.dist + p.weight;
                        pq.offer(dNext);
                    }
                }
            }
        }

        System.out.println(dist[D].dist);

    }
}
class Dist implements Comparable<Dist>{
    int idx, dist;

    public Dist(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Dist o) {
        return this.dist - o.dist;
    }
}


class Point{
    int start, end, weight;

    public Point(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

