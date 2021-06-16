import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        int N = 0;
        int M = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);
        binary(arr,0, arr[N-1], M);



    }

    public static void binary(int[] arr, int low, int high, int M) {


        int res = 0;

        while(low <= high) {
            long sum = 0;
            int mid = (low + high) / 2;

            for(int i = 0; i < arr.length; i++) {
                if(mid < arr[i]) sum += arr[i] - mid;
            }

            if(sum < M) high = mid - 1;
            else {
                low = mid + 1;
                res = mid;
            }
        }

        System.out.println(res);

    }



}
