import java.util.Arrays;
import java.util.Scanner;

/**
 * Programmers H-index
 *
 * [주의] "h번 이상 인용된 논문이 h편 이상이고"의 부분에서 arr[i]번 이상 인용된 논문이 아니라
 * 0부터 arr.length번 중에 h번 이상 인용된 논문이 h편 이상인 경우를 찾는거임.
 *
 * 테스트 케이스를 헷갈리게 내놔서 문제의 본질적 파익이 어려웠다..ㅡㅡ
 */
public class Main {
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= arr.length - i) {
                max = arr.length - i;
                break;
            }
        }
        System.out.println(max);
    }
}
