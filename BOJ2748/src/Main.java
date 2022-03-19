import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n + 1];

        Arrays.fill(arr, -1);

        arr[0] = 0;
        arr[1] = 1;

        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int n) {
        if(arr[n] == -1) {
            arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return arr[n];
    }
}
