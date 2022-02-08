import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int X, K; // X 수빈, K 동생

    static final int LIMIT = 100001;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[] visited = new boolean[LIMIT];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue.offer(new int[]{X, 0});

        bfs();
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curPoint = cur[0];
            int curDepth = cur[1];

            if(K == curPoint) {
                System.out.println(curDepth);
                return;
            }

            int nextBack = curPoint - 1;
            int nextFront = curPoint + 1;
            int nextMove = curPoint * 2;

            if(nextBack >= 0 && nextBack < LIMIT && !visited[nextBack]) {
                queue.offer(new int[]{nextBack, curDepth + 1});
                visited[nextBack] = true;
            }

            if(nextFront >= 0 && nextFront < LIMIT && !visited[nextFront]) {
                queue.offer(new int[]{nextFront, curDepth + 1});
                visited[nextFront] = true;
            }

            if (nextMove >= 0 && nextMove < LIMIT && !visited[nextMove]) {
                queue.offer(new int[]{nextMove, curDepth + 1});
                visited[nextMove] = true;
            }
        }

    }
}
