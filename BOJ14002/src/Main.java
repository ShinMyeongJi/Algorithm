import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main2
 * author :  home
 * date : 22. 9. 24.
 * description : 아
 */
public class Main {

    static int n;
    static List<Integer> result = new ArrayList<>();
    static int[] seq;
    static int[] dp;
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        seq = new int[n + 1];
        dp = new int[n + 1];

        int max = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                index = i;
            }


        }


        System.out.println(max);
        setSeq(max);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public static void setSeq(int max) {
       /* StringBuilder sb = new StringBuilder();
        int value = max;
        Stack<Integer> stack = new Stack<>();

        for (int i = n; i >= 1; i--) {
            if (value == dp[i]) {
                stack.push(seq[i]);
                value--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
*/
        //System.out.println(sb.toString());

        int temp = max;
        for (int j = n; j > 0; j--) {
            if (dp[j] == temp) {
                result.add(seq[j]);
                temp--;
            }
        }
        result.sort(Comparator.naturalOrder());
    }


}

