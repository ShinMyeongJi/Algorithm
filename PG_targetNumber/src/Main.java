import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */

public class Main {
    static int resCnt = 0;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,0, 0, target);
        answer = resCnt;
        return answer;
    }

    public static void dfs(int[] numbers, int cnt, int res, int target) {
        if(cnt == numbers.length) {
            if(target == res) {
                resCnt++;
            }
            return;
        }

        int plus = numbers[cnt];
        int minus = numbers[cnt] * -1;

        dfs(numbers, cnt + 1, res + plus, target);
        dfs(numbers, cnt + 1, res + minus, target);
    }
}
