import java.util.LinkedList;
import java.util.Queue;

class Solution {
// https://leveloper.tistory.com/102
// https://gre-eny.tistory.com/169
    private int n;
    private int[][] board;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    private final int[] rdx = {-1, 1, 1, -1};
    private final int[] rdy = {1, 1, -1, -1};

    public int solution(int[][] board) {
        this.board = board;
        this.n = board.length;

        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(0, 0, 0, 0));
        boolean[][][] visit = new boolean[n][n][4];
        visit[0][0][0] = true;

        return bfs(queue, visit);
    }

    private int bfs(Queue<Robot> queue, boolean[][][] visit) {
        int x, y, dir, time, ox, oy;
        int nx, ny, nox, noy, ndir;
        int rx, ry;

        while(!queue.isEmpty()) {
            Robot robot = queue.poll();

            x = robot.x;
            y = robot.y;

            dir = robot.dir;
            time = robot.time;

            ox = robot.getOtherX();
            oy = robot.getOtherY();

            if (isFinish(x, y) || isFinish(ox, oy)) return time;

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                nox = ox + dx[i];
                noy = oy + dy[i];

                if (!isValid(nx, ny) || !isValid(nox, noy)) continue;
                if (board[nx][ny] == 1 || board[nox][noy] == 1) continue;
                if (visit[nx][ny][dir]) continue;

                visit[nx][ny][dir] = true;
                queue.add(new Robot(nx, ny, dir, time + 1));
            }

            for (int i = 1; i < 4; i += 2) {
                ndir = (dir + i) % 4;
                nox = x + dx[ndir];
                noy = y + dy[ndir];

                int tempDir = (i == 1) ? ndir : dir; rx = x + rdx[tempDir];
                ry = y + rdy[tempDir];
                if (!isValid(nox, noy) || !isValid(rx, ry)) continue;
                if (board[nox][noy] == 1 || board[rx][ry] == 1) continue;
                if (visit[x][y][ndir]) continue;
                visit[x][y][ndir] = true;
                queue.add(new Robot(x, y, ndir, time + 1));
            }

            dir = (dir + 2) % 4;
            for (int i = 1; i < 4; i += 2) {
                ndir = (dir + i) % 4;
                nx = ox + dx[ndir];
                ny = oy + dy[ndir];

                int tempDir = (i == 1) ? ndir : dir;
                rx = ox + rdx[tempDir];
                ry = oy + rdy[tempDir];
                ndir = (ndir + 2) % 4;
                if (!isValid(nx, ny) || !isValid(rx, ry)) continue;
                if (board[nx][ny] == 1 || board[rx][ry] == 1) continue;
                if (visit[nx][ny][ndir]) continue;

                visit[nx][ny][ndir] = true;
                queue.add(new Robot(nx, ny, ndir, time + 1));
            }
        }

        return -1;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private boolean isFinish(int x, int y) {
        return x == n - 1 && y == n - 1;
    }

    private class Robot{
        int x, y;
        int dir;
        int time;

        Robot(int x, int y, int dir, int time) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
        }

        public int getOtherX() {
            return x + dx[dir];
        }

        public int getOtherY() {
            return y + dy[dir];
        }
    }

    /*int N;
    int[][] board;
    final int[] dy = {0, 1, 0, -1};
    final int[] dx = {1, 0, -1, 0};
    final int[] rdy = {-1, 1, 1, -1};
    final int[] rdx = {1, 1, -1, -1};


    public int solution(int[][] board) {
        this.board = board;
        this.N = board.length;

        boolean[][][] visited = new boolean[N][N][4];

        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0, 0, 0, 0));
        visited[0][0][0] = true;

        int x, y, dir, cnt, ox, oy;
        int nx, ny, nox, noy, ndir;
        int rx, ry; // 회전할 떄 지나가는 좌표

        while (!q.isEmpty()) {
            Info cur = q.poll();

            y = cur.y;
            x = cur.x;
            dir = cur.dir;
            cnt = cur.cnt;
            oy = cur.getTheOtherY();
            ox = cur.getTheOtherX();

            if (isFinish(y, x) || isFinish(oy, ox)) {
                return cnt;
            }

            // 회전을 하지 않을 때
            for (int i = 0;  i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                noy = y + dy[i];
                nox = x + dx[i];

                if (isRange(ny, nx) && isRange(noy, nox)
                        && board[ny][nx] == 0 && board[noy][nox] == 0
                        && !visited[ny][nx][dir]) {
                    visited[ny][nx][dir] = true;
                    q.offer(new Info(ny, nx, dir, cnt + 1));
                }
            }

            // x,y 기준으로 회전
            for (int i = 1; i < 4; i+=2) {
                ndir = (i + dir) % 4;
                noy = y + dy[ndir]; // 회전하는 다른 좌표
                nox = x + dx[ndir]; // 회전하는 다른 좌표

                int tempDir = (i == 1) ? ndir : dir;
                ry = y + rdy[tempDir];
                rx = x + rdx[tempDir];

                if (isRange(ry, rx) && isRange(noy, nox) && board[ry][rx] == 0 && board[noy][nox] == 0 && !visited[y][x][ndir]) {
                    visited[y][x][ndir] = true;
                    q.offer(new Info(y, x, ndir, cnt + 1));
                }
            }


            // ox, oy 기준으로 회전
            dir = (dir + 2) % 4;
            for (int i = 1; i < 4; i+=2) {
                ndir = (i + dir) % 4;
                ny = oy + dy[ndir]; // 회전한 좌표
                nx = ox + dx[ndir]; // 회전한 좌표

                int tempDir = (i == 1) ? ndir : dir;
                ry = oy + rdy[tempDir];
                rx = ox + rdx[tempDir];

                if (isRange(ry, rx) && isRange(ny, nx) && board[ry][rx] == 0 && board[ny][nx] == 0 && !visited[ny][nx][ndir]) {
                    visited[ny][nx][ndir] = true;
                    q.offer(new Info(ny, nx, ndir, cnt + 1));
                }
            }
        }

        return -1;
    }

    public boolean isRange(int y, int x) {
        if (y >= 0 && y < N && x >= 0 && x < N) return true;
        else return false;
    }

    public boolean isFinish(int y, int x) {
        if (y == N - 1 && x == N -1) return true;
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

        public int getTheOtherX() {
            return this.x + dx[dir];
        }

        public int getTheOtherY() {
            return this.y + dy[dir];
        }
    }*/
}
