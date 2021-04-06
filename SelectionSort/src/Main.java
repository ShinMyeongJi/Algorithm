import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * JONGOL 1146
 */

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        int[] nums = new int[N];
        StringTokenizer  st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < N; i++) {
            min = nums[i];
            index = i;
            for(int j = i + 1; j < N; j++) {
                if(min > nums[j]) {
                    min = nums[j];
                    index = j;
                }
            }
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            if(i != N-1) {
                for(int k = 0; k < N; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
