import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*int N = 0;

        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bw.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(bw.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = 2; i < N; i++) {
            for(int j = 0; j < j + i && j < N - i; j++) {

            }
        }*/

        int N = 0;

        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bw.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(bw.readLine());

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
            if(max < sum) max = sum;
            if(sum < 0) sum = 0;
        }
        System.out.println(max);
    }
}
