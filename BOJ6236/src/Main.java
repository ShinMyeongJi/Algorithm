import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.MAX_VALUE;

        int[] moneyPlans = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            moneyPlans[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, moneyPlans[i]);
            sum += moneyPlans[i];
        }

        int low = max;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 1;

            int prevCharge = mid;

            for (int i = 0; i < N; i++) {

                if (prevCharge - moneyPlans[i] < 0) {
                    prevCharge = mid;
                    cnt++;
                }
                prevCharge = prevCharge - moneyPlans[i];
            }

            if (cnt <= M) {
                K = Math.min(K, mid);
                high = mid - 1;
            }else low = mid + 1;
        }

        System.out.println(K);
    }
}
