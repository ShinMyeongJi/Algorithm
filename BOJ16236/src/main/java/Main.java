import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int N;
    static int[][] space;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static class Fish {
        int size = 2;
        int x, y; // 아기 상어 위

    }

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        space = new int[N][N];
        Fish babyFish = new Fish();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9)  {
                    babyFish.x = i;
                    babyFish.y = j;
                }
            }
        }


        checkFishOnSpaced();
    }

    public static void checkFishOnSpaced() {


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //if (space[i][j] )
            }
        }

        // 1마리면 먹으러
            // 물고기가 공간에 없다면 엄마 호출
        // 1 마리보다 많으면 가장 가까운 물고기
            // 지나가는 최소 칸 수가 여러 개면 가장 위에 있는 물고기
                // 그것도 여러 개면 가장 왼쪽 거

    }

    public static void bfs() {

    }

}
