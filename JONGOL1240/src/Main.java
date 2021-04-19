import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long val = Long.parseLong(br.readLine());
        System.out.println(binarySearch(val));
    }

    public static long binarySearch(long value) {
        long start = 1;
        long end = value / 2;
        long mid = 0;
        long res = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if(mid <= value / mid) {
                res = mid;
                end = mid + 1;
            }else{
                end = mid - 1;
            }
        }


        return res;
    }
}
