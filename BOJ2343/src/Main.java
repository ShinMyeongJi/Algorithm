import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 이진탐색의 경 무엇을 탐색하는지를 생각하고 이를 탐색 대상으로 계산할 수 있게 식을 유도하는 것이 옳은 해법이다.
 */
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
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, arr[i]);
        }

        int high = IntStream.of(arr).sum();


        while(low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(sum + arr[i] > mid) {
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

        System.out.println(low);
    }
}
