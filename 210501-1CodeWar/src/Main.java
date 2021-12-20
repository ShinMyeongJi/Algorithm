import java.util.ArrayList;
import java.util.List;

/**
 * 210501
 * Code War - Integers: Recreation One
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(listSquared(1, 250));

    }

    public static String listSquared(long m, long n) {
        //
        for(long i = m; i < n; i++) {
            List<Long> divisors = new ArrayList<>();
            for(long j = 0; j * j < i; j++) {
                if(i % j == 0) divisors.add(j);
            }
        }
        return "";
    }
}
