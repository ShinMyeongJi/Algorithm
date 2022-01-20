import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, D;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<Point> list = new ArrayList<>();
        int[] dist = new int[N];

        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(end > D || weight >= (end - start)) continue;
            list.add(new Point(start, end, weight));
        }



        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < )

        while (!pq.isEmpty()) {
            Point nowP = pq.poll();


        }

    }
}

class Point implements Comparable<Point>{
    int start, end, weight;

    public Point(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Point o) {
        return 0;
    }
}