import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 현재 층수
        G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
        U = Integer.parseInt(st.nextToken()); // 위로 갈 수 있는 층수
        D = Integer.parseInt(st.nextToken()); // 아래로 갈 수 있는 층수

        visited = new boolean[F + 1];

        q.offer(new int[]{S, 0});
        bfs();
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();

            int p = temp[0];
            int cnt = temp[1];

            if (p == G) {
                System.out.println(cnt);
                return;
            }

            int up = temp[0] + U;
            int down= temp[0] - D;

            if (up > 0 && up <= F && !visited[up]) {
                visited[up] = true;
                q.offer(new int[]{up, cnt + 1});
            }

            if (down > 0 && down <= F && !visited[down]) {
                visited[down] = true;
                q.offer(new int[]{down, cnt + 1});
            }
        }

        System.out.println("use the stairs");
    }
}
