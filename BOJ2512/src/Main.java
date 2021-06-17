import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int low = 0, high = arr[N-1];
        int res = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for(int i = 0; i < N; i++) {
                sum += Math.min(mid, arr[i]);
            }

            if(sum <= M) {
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.println(res);
    }
}
