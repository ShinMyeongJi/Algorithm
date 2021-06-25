import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        removNb(26);
    }

    public static List<long[]> removNb(long n) {
        List<long[]> res = new ArrayList<>();

        long sum = n * (n-1) / 2;

        for(long i = 1; i <= n; i++) {
            long a = i;
            long b = n - i;

            if(a * b == sum - (a+b)) res.add(new long[]{a, b});
        }

        System.out.println(Arrays.deepToString(res.toArray()));

        return null;
    }
}
