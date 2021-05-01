/**
 * 210501
 * Code War - Maximum subarray sum
 *
 * 기존 부분 수열의 합과는 다른 점은 모든 원소가 "음수"일 땐 최댓값을 0으로 출력한다는 것.
 * 떄문에 음수 원소들의 합들 까지 모두 헤아릴 필요없이 양수의 값이 나올 때만 체크해주면 된다.
 *
 * [기존 부분 수열의 합 풀이법]
 * 1. 완전탐색
 * 2. 부분합수열
 * 3. 분할정복
 * 4. 동적 계획법
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 4, 1, 2, 1, 5, 4};
        System.out.println(sequence(arr));
    }

    public static int sequence(int[] arr) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sum < 0) sum = 0;
            if(sum >= 0) {
                sum += arr[i];
                if(sum > max) max = sum;
            }
        }

        return max;
    }
}
