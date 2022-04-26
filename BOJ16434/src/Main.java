import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int hatk; // 용사 초기 공격력

    static int[][] roomInfos;
    public static void main(String[] args) throws IOException {
        long res = 0;

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
        long high = (long)Math.pow(10, 12);

        while (low <= high) {
            long mid = (low + high) / 2; // 용사의 최대 생명력

            if(check(hatk, mid)) {
                high = mid - 1;
                res = mid;
            }else {
                low = mid + 1;
            }
        }

        System.out.println(res);
    }

    public static boolean check(long curAtckPoint, long mid) { // 용사가 살 수 있는지 없는지 체크한다.
        long H = mid;
        long attackPoint = curAtckPoint;

        for (int i = 0; i < N; i++) {
            long type = roomInfos[i][0];
            // roomInfos[i][1]; 몬스터의 공격력 or 공격력 증가
            // roomInfos[i][2]; 몬스터의 생명력 or 회복력

            if(type == 1) {
                long cnt = roomInfos[i][2] / attackPoint;
                if (roomInfos[i][2] % attackPoint == 0) cnt--;

                H -= cnt * roomInfos[i][1]; // 몬스터가 공격

                if (H <= 0) return false;
            }else {
                attackPoint += roomInfos[i][2];
                H = Math.min(H + roomInfos[i][1], mid);
            }
        }

        return true;
    }
}
