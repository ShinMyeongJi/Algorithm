import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};

    boolean[][] visited;
    Queue<int[]> q = new LinkedList<>();

    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    int M, N;

    int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        this.M = m;
        this.N = n;
        this.picture = picture;

        visited = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    q.offer(new int[]{i, j});
                    bfs(picture[i][j]);
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public void bfs(int val) {
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = temp[0] + dy[i];
                int nextX = temp[1] + dx[i];

                if (isRange(nextY, nextX) && !visited[nextY][nextX] && picture[nextY][nextX] == val) {
                    q.offer(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                    cnt++;
                }

            }
        }

        numberOfArea++;
        maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
    }

    public boolean isRange(int y, int x) {
        if (y >= 0 && y < M && x >=0 && x < N) return true;
        return false;
    }


}
