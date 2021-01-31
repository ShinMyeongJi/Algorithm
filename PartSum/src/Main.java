import java.util.Scanner;

/**
 * 백준 1182
 * Backtracking 사용하기
 */
public class Main {
    static int n = 0,s = 0;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) {

        String nums;

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        s = kb.nextInt();

        kb.nextLine();
        nums = kb.nextLine();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(nums.split(" ")[i]);
        }

        for(int i = 0; i < n; i++){
            backtracking(arr[i], i);
        }

        System.out.println(count);

    }

    public static void backtracking(int res, int depth){
        if(n-1 == depth && res == s){
            count++;
        }

        depth++;
        if(depth < n){
            backtracking(res + arr[depth], depth);
            backtracking(res, depth);
        }
    }
}
