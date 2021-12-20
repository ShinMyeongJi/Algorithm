import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int K, N; // K 가지고 있는 랜선의 개수, N 만드려는 랜선의 개수

        long arr[];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];

        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long low = 1;
        long high = arr[K-1];
        long result = 0;

        while(low <= high) {
            long mid = (low + high) / 2;

            int cnt = 0;

            for (int i = 0; i < K; i++) {
                if(arr[i] >= mid) {
                    cnt += arr[i] / mid;
                }
            }

            if(cnt >= N) {
                low = mid + 1;
                result = Math.max(result, mid);

            }else{
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
