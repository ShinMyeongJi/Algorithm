import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static final int SIZE = 5;
    public static String[] colors = new String[SIZE];
    public static int[] nums = new int[SIZE];
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i  = 0; i < SIZE; i++) {
            st = new StringTokenizer(bw.readLine());
            colors[i] = st.nextToken();
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        ArrayList list = new ArrayList();

        list.add(condition1());
        list.add(condition2());
        list.add(condition3());
        list.add(condition4());
        list.add(condition5());
        list.add(condition6());
        list.add(condition7());
        list.add(condition8());

        int max = (int) Collections.max(list);
        if(max == 0) System.out.println(condition9());
        else System.out.println(max);
    }
    //조건 1. 카드 5장이 모두 같은 색이면서 숫자가 연속적일 때 가장 높은 숫자에 900을 더한다.
    public static int condition1(){
        for(int i = 0; i < SIZE - 1; i++) {
            if(!colors[i].equals(colors[i + 1])) return 0;
        }

        for (int i = 0; i < SIZE - 1; i++) {
            if(nums[i] + 1 != nums[i+1]) return 0;
        }
        return 900 + nums[SIZE-1];
    }

    //조건 2. 카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다.
    public static int condition2() {
        int min = nums[0];
        int max = nums[SIZE-1];

        int countMin = 1, countMax = 1;
        for(int i = 1; i < SIZE-1; i++) {
            if(min == nums[i]) countMin++;
            if(max == nums[SIZE-i-1]) countMax++;
        }
        if(countMin == 4) return 800 + min;
        if(countMax == 4) return 800 + max;

        return 0;
    }

    /* 조건 3. 카드 5장 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때
       점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더한다. */
    public static int condition3() {
        int min = nums[0];
        int max = nums[SIZE-1];

        int countMin = 1, countMax = 1;

        for(int i = 1; i < SIZE-1; i++) {
            if(min == nums[i]) countMin++;
            if(max == nums[SIZE-i-1]) countMax++;
        }

        if(countMin == 2 && countMax == 3) return (max * 10) + min + 700;
        if(countMin == 3 && countMax == 2) return (min * 10) + max + 700;

        return 0;
    }

    // 조건 4. 5장의 카드 색깔이 모두 같을 때 점수는 가장 높은 숫자에 600을 더한다.
    public static int condition4() {
        for(int i = 0; i < SIZE - 1; i++) {
            if(!colors[i].equals(colors[i + 1])) return 0;
        }

        return 600 + nums[SIZE-1];
    }

    // 조건 5. 카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다.
    public static int condition5() {
        for(int i = 0; i < SIZE - 1; i++) {
            if(nums[i] + 1 != nums[i + 1]) return 0;
        }
        return 500 + nums[SIZE - 1];
    }

    // 조건 6. 카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다.
    public static int condition6() {
        int min = nums[0];
        int max = nums[SIZE - 1];
        int mid = nums[SIZE/2];

        int countMin = 1, countMax = 1, countMid = 1;

        for(int i = 1; i < SIZE; i++) {
            if(min == nums[i]) countMin++;
            if(max == nums[SIZE - 1 - i]) countMax++;
        }

        if(countMin == 3) return 400 + min;
        if(countMax == 3) return 400 + max;
        if(mid == nums[SIZE/2-1] && mid == nums[SIZE/2+1]) return 400 + mid;

        return 0;
    }

    /* 조건 7. 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때
        점수는 같은 숫자 중 큰 숫자에 10을 곱하고 작은 숫자를 더한 후 300을 더한다.
    */
    public static int condition7() {
        int min = nums[0];
        int max = nums[SIZE-1];
        int mid = nums[SIZE/2];

        int countMin = 1, countMax = 1;

        for(int i  = 1; i < SIZE; i++) {
            if(min == nums[i]) countMin++;
            if(max == nums[SIZE - 1 -i]) countMax++;
        }

        if(countMin == 2 && countMax != 2) {
            if(mid == nums[SIZE/2 + 1]) {
                return (10 * mid) + min + 300;
            }
        }else if(countMin != 2 && countMax == 2) {
            if(mid == nums[SIZE/2 - 1]) {
                return (10 * max) + mid + 300;
            }
        }else if(countMin == 2 && countMax == 2) {
            return (10 * max) + min + 300;
        }

        return 0;
    }

    // 조건 8. 카드 5장 중 2장의 숫자가 같을 때 같은 숫자에 200을 더한다.
    public static int condition8() {
        int cnt = 1;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(i != j) {
                    if(nums[i] == nums[j]) cnt++;
                    if(cnt > 2) {
                        cnt = 1;
                        break;
                    }
                }
            }
            if(cnt == 2) return 200 + nums[i];
        }
        return 0;
    }


    // 조건 9. 어떤 경우도 해당하지 않을 때 가장 큰 숫자에 100을 더한다.
    public static int condition9() {
        return 100 + nums[SIZE - 1];
    }
}
