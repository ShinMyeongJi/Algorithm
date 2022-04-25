import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int hatk; // 용사 초기 공격력

    static int[][] roomInfos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hatk = Integer.parseInt(st.nextToken());

        roomInfos = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            roomInfos[i][0] = Integer.parseInt(st.nextToken());
            roomInfos[i][1] = Integer.parseInt(st.nextToken());
            roomInfos[i][2] = Integer.parseInt(st.nextToken());
        }

        long low = 1;
        long high = Long.MAX_VALUE;

        while (low <= high) {
            long mid = (low + high) / 2; // 용사의 최대 생명력

            long pAtckPoint = hatk;
            long cur = mid;
            for (int i = 0; i < N; i++) {
                long type = roomInfos[i][0];
                long attackPoint = roomInfos[i][1]; // 용사의 공격력 or 공격력 증가
                long hp = roomInfos[i][2]; // 몬스터의 생명력 or 회복력

                if(type == 1) {
                    while () {

                    }

                }else {

                }
            }
        }

    }
}
