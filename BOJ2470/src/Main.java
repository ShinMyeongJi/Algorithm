import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        int[] densities;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        densities = new int[N];

        Arrays.sort(densities);

        int low = 0, high = N-1;
        int min = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if(densities[ )
            }
        }
    }
}
