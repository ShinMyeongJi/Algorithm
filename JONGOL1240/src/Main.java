import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JONGOL 1240
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long val = Long.parseLong(br.readLine());
        //System.out.println(binarySearch(val));
        System.out.println(babilonia(val, 2));
    }

    /*public static long binarySearch(long value) {
        long start = 1;
        long end = value;
        long mid = 0;
        long res = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(mid * mid <= value) {
                start = mid + 1;
                res = mid;
            }else {
                end = mid - 1;
            }
        }
        return res;
    }*/

    // 조건을 어떻게 걸어주냐에 따라 다름
    //
    public static long babilonia(long x, long xn) {
        for(int i = 0; i < 100; i++) {
            xn = (xn + x / xn) / 2;
        }

        return xn;
    }
}
