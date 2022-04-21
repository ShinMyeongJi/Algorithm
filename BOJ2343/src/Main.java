import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int low = -1;
        int high = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        int res = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            int remainLength = mid;

            for (int i = 0; i < N; i++) {
                if (remainLength - arr[i] < 0) {
                    cnt++;
                    remainLength = mid;
                }
                remainLength -= arr[i];
            }

            if (remainLength > 0) cnt++;

            if (cnt <= M) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}



        /*int high = IntStream.of(arr).sum();


        while(low <= high) {
                int mid = (low + high) / 2;
                int cnt = 0;
                int sum = 0;
                for(int i = 0; i < N; i++) {
        if(sum + arr[i] > mid) { // 초과되면 딱 그 직전까지만 더한다.
        cnt++;
        sum = 0;
        }
        sum += arr[i];
        }

        if(sum != 0) cnt++;

        if(cnt <= M) {
        high = mid - 1;
        }else{
        low = mid + 1;
        }

        }

        System.out.println(low);*/