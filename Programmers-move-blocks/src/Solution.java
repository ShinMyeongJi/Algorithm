import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int N = 0;
    int[][] board;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};


    public int solution(int[][] board) {
        this.board = board;
        this.N = board.length;

        boolean[][][] visited = new boolean[N][N][4];

        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Info cur = q.poll();

            // 회전을 하지 않을 때
            for (int i = 0;  i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int noy = cur.y + dy[i];
                int nox = cur.x + dx[i];

                if (isRange(ny, nx) && isRange(noy, nox)
                        && isRoad(ny, nx) && isRoad(noy, nox)
                        && !visited[ny][nx][cur.dir] && !visited[noy][nox][cur.dir]) {
                    visited[ny][nx][cur.dir] = true;
                    q.offer(new Info(ny, nx, cur.dir, cur.cnt + 1));
                }
            }

            // x,y 기준으로 회전
            for (int i = 1; i < 4; i+=2) {

            }


            // ox, oy 기준으로 회전
        }
    }

    public boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < N) return true;
        else return false;
    }

    public boolean isRoad(int y, int x) {
        if (board[y][x] == 0 && board[y][x] == 0) return true;
        return false;
    }

    class Info {
        // y 세로, x 가로
        int y;
        int x;
        int dir;
        int cnt;

        public Info(int y, int x, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        public int getTheOtherX(int x) {
            return x + dx[dir];
        }

        public int getTheOtherY(int y) {
            return y + dy[dir];
        }
    }
}
