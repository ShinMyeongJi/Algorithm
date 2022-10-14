import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][] powers;
    static boolean[] visited;

    static int resMin = Integer.MAX_VALUE; // 능력치의 최소 값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        powers = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                powers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 일단 팀을 반으로 나누면 되는데 그럼 카운트는 N/2이까지다.

        backtracking(0, 0);
        System.out.println(resMin);
    }

    public static void backtracking(int cnt, int ni) {

        if (cnt == N/2) {

           int teamStart = 0;
           int teamLink = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) teamStart += powers[i][j];
                    if (!visited[i] && !visited[j]) teamLink += powers[i][j];
                }
            }

            resMin = Math.min(resMin, Math.abs(teamStart - teamLink));

            return;
        }

        for (int i = ni; i < N; i++) {
            if (visited[i]) continue;;
            visited[i] = true;
            backtracking(cnt + 1, i + 1);
            visited[i] = false;
        }
    }

}
