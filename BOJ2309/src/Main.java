import java.util.*;

/**
 * BOJ 2309
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[9];
        List<Integer> dwarf = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        Scanner kb = new Scanner(System.in);

        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            nums[i] = kb.nextInt();
            sum += nums[i];
        }

        for(int j = 0; j < 8; j++){
            for(int k = j+1; k < 9; k++){
                int cal = sum - (nums[j] + nums[k]);

                if(cal == 100){
                    idx1 = j;
                    idx2 = k;
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++){
            if(i == idx1 || i == idx2) continue;
            dwarf.add(nums[i]);
        }

        Collections.sort(dwarf);

        for (Integer integer : dwarf) {
            System.out.println(integer);
        }
    }
}
