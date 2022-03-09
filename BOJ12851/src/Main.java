import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int LIMIT = 100001;
    static int N, K; // N 수빈, K 동생
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited = new boolean[LIMIT];

    static int second = Integer.MAX_VALUE;
    //static int ways = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited[N] = true;
        q.offer(N);

        bfs();
    }

    public static void bfs() {
        int time = 0;
        int ways = 0;
        while(!q.isEmpty()) {
            int val = q.poll();
            ways += 1;
            //int[] temp = q.poll();
            //int val = temp[0];
            //int cnt = temp[1];

            /*if (val == K && isSmaller(cnt)) {
                ways += 1;
                System.out.println(cnt);
                System.out.println(ways);
                continue;
            }*/

            /*int minusX = val - 1;
            int plusX = val + 1;
            int move = val * 2;

            if (minusX >= 0 && minusX < LIMIT && !visited[minusX]) {
                //q.offer(new int[]{minusX, cnt + 1});
                visited[minusX] = true;
            }
            if (plusX >= 0 && plusX < LIMIT && !visited[plusX]) {
                //q.offer(new int[]{plusX, cnt + 1});
                visited[plusX] = true;
            }
            if (move >= 0 && move < LIMIT && !visited[move]) {
                //q.offer(new int[]{move, cnt + 1});
                visited[move] = true;
            }*/

            int[] next = {val - 1, val + 1, val * 2};

            for (int i = 0; i < next.length; i++) {
                if (next[i] >= 0 && next[i] < LIMIT && !visited[next[i]]) {
                    if (next[i] == K) {
                        time += 1;
                        continue;
                    }
                    q.offer(next[i]);
                }
            }
        }
        System.out.println(time);
        System.out.println(ways);
    }

    public static boolean isSmaller(int x) {
        return second > x;
    }
}
