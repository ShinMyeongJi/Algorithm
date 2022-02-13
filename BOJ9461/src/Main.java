import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int T, N;

        long[] seq = new long[101];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        seq[0] = 0;
        seq[1] = 1;
        seq[2] = 1;
        seq[3] = 1;

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            for (int j = 4; j <= N; j++) {
                seq[j] = seq[j - 2] + seq[j - 3];
            }

            System.out.println(seq[N]);
        }


    }
}
