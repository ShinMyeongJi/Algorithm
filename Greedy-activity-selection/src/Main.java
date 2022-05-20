import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Greedy 활동 선택 문
 9
 1 3
 2 5
 8 10
 4 7
 5 9
 9 11
 11 14
 13 16
 1 8
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> res = new ArrayList<>();

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] times = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            times[i][0] = i;
            times[i][1] = Integer.parseInt(st.nextToken());
            times[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });


        int last = 0;
        for (int i = 0; i < N; i++) {
            if (last < times[i][1]) {
                res.add(i + 1);
                last = times[i][2];
            }
        }


        System.out.println(res.toString());
    }
}
