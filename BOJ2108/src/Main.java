import java.util.*;

/**
 * BOJ 2108
 */
public class Main {
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = kb.nextInt();
        }

        // 산술평균
        int mean = 0;
        for(int i = 0; i < N;i++){
            mean += nums[i];
        }

        System.out.println((int)Math.round((double)mean / N));

        // 중앙값
        Arrays.sort(nums);
        System.out.println(nums[N/2]);

        // 최빈값
        System.out.println(getMode(nums));


        // 최댓값 - 최솟값
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            if(max < nums[i]) max = nums[i];
            if(min > nums[i]) min = nums[i];
        }

        System.out.println(max - min);
    }

    public static int getMode(int[] nums) {
        int mode = 0;
        int[] index = new int[8001];

        int max = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
           index[nums[i]+4000]++;
        }

        for (int i =0; i < 8001; i++){
            if(max <= index[i])
                max = index[i];
        }

        for(int i = 0; i < 8001; i++){
            if(max == index[i])
                list.add(i-4000);
        }

        if(list.size() == 1) {
            mode = list.get(0);
        }
        else{
            Collections.sort(list);
            mode = list.get(1);
        }

        return mode;
    }
}
