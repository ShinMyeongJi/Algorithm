import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, C = 0;

        int[] arr;
        int res = Integer.MIN_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[N - 1] - arr[0];



        while (low <= high) {
            int cnt = 1;
            int mid = (low + high) / 2;
            int prevHome = arr[0];

            for (int i = 1; i < N; i++) {
                if (mid <= arr[i] - prevHome) {
                    cnt++;
                    prevHome = arr[i];
                }
            }

            if (cnt >= C) {
                res = Math.max(res, mid);
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        System.out.println(res);
    }
}
