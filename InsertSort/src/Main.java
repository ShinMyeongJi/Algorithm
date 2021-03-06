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

        int cnt = 0;

        for(int i = 1; i < N; i++) {
            int cur = nums[i];
            int index = i;
            for(int j = i - 1; j >= 0; j--) {
                if(cur < nums[j]) {
                    int temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;
                    index = j;
                    cnt++; //JONGOL1814
                }
            }
            for(int k = 0; k < N; k++) {
                System.out.print(nums[k] + " ");
            }
            System.out.println();
        }
        System.out.println(cnt); //JONGOL1814
    }
}
