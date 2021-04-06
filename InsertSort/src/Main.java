import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * JONGOL 1158
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            for(int k = 0; k < N; k++) {
                System.out.print(nums[k]);
            }
            System.out.println();
        }

        for(int i = 0; i < N; i++) {
            System.out.println(nums[i]);
        }
    }
}
