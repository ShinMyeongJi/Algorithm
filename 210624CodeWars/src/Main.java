import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * m와 n사이의 수를 대상으로, 약수의 제곱이 합이 제곱수가 되는 자연수와 그 제곱의 합을 출력
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(listSquared(1, 250));
    }

    public static String listSquared(long m, long n) {
        List<Long[]> res = new ArrayList<>();
        for(long i = m; i <= n; i++) { // i의 약수 구하기
            List<Long> divisor = new ArrayList<>();

            for(long j = 1; j <= i; j++) {
                if(i % j == 0) {
                    if (!divisor.contains(j)) divisor.add(j);
                }
            }

            if(!divisor.isEmpty()) {
                long sum = divisor.stream().map(item -> item*item).reduce(Long::sum).get();
                if((long)Math.sqrt(sum) * (long)Math.sqrt(sum) == sum) {
                    res.add(new Long[]{i, sum});
                }
            }
        }

        return Arrays.deepToString(res.toArray());
    }
}
