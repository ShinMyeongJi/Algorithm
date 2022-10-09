import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  shinmj
 * date : 22. 10. 10.
 * description :
 */
public class Main {

    static final int MAX_DIST = 21;
    static int N;
    static int[][] space;
    static int[][] dist;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int minDist; // 최소 거표
    static int minY, minX; // 최소 거리의 좌표

    static int curFishCnt = 0; // 현재까지 먹은 물고기 크기 수 합

    static int second = 0;
    static class Fish {
        int size = 2;
        int x, y; // 아기 상어 위

    }

    static Fish babyFish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        space = new int[N][N];
        dist = new int[N][N];

        babyFish = new Fish();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9)  {
                    babyFish.y = i;
                    babyFish.x = j;
                    space[i][j] = 0; // 얘를 생각 못 했네
                }
            }
        }

        while (true) {
            resetDist();

            bfs(babyFish.y, babyFish.x);

            // 더 이상 물고기 없을 때는 어떻게 체크?
            if (minY != MAX_DIST && minX != MAX_DIST) {


                // 초 세줘야되고 // 초는 이동시간..즉, 이동 거리
                second += minDist;

                // 먹는 거 처리해줘야되고
                space[minY][minX] = 0;
                curFishCnt++;

                // 자기 크기랑 같은 수의 물고기 먹었을 때 크기 1씩 증가
                if (babyFish.size == curFishCnt) {
                    babyFish.size++;
                    curFishCnt = 0;
                }

                babyFish.y = minY;
                babyFish.x = minX;


            }else {
                break;
            }
        }

        System.out.println(second);

    }



    // bfs로 최단거리를 체크하기는 하는데.. 물고기가 있는지도 체크를 여기서 하나?

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        dist[y][x] = 0;
        q.offer(new int[]{y, x});

        while(!q.isEmpty()) {

            int[] temp = q.poll();

            int curY = temp[0];
            int curX = temp[1];

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if(isRange(nextY, nextX)) {

                    //다시 생각해보자
                    if (dist[nextY][nextX] == -1 && space[nextY][nextX] <= babyFish.size) { //방문하지 않았거나 // 아기상어보다 작거나 같아야
                        // 일단 지나갈 수 있음

                        dist[nextY][nextX] = dist[curY][curX] + 1;

                        //이제 먹을 수 있는지를 체크해야되는거
                        if (space[nextY][nextX] != 0 && space[nextY][nextX] < babyFish.size) {// 일단 물고기가 있어야 되고 // 아기상어보다 작아야 됨
                            // 1마리면 최소 거리와 최소 좌표를 갱신한다.
                            if (minDist > dist[nextY][nextX]) {
                                minDist = dist[nextY][nextX];
                                minY = nextY;
                                minX = nextX;
                            }else if (minDist == dist[nextY][nextX]) { // 1마리 이상이면(현재 최소거리와 똑같은게 여러개면) 최소 거리와 최소 좌표가
                                // 가장 위이거나
                                if (minX == nextX) {
                                    if (minY > nextY) {
                                        //minX = nextX;
                                        minY = nextY;
                                    }
                                } else if (minX > nextX) { // 왼쪽이거나
                                    minX = nextX;
                                    minY = nextY;
                                }
                            }
                        }
                        q.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }

    public static boolean isRange(int y, int x) {
        return !(y < 0 || y >= N || x < 0 || x >= N);
    }

    public static void resetDist() {
        minDist = 41;
        minY = MAX_DIST;
        minX = MAX_DIST;

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
    }
}
