import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//LIS 이

public class Main {

    public static void main(String[] args) throws IOException {
        int A;
        int[] seq;
        int[] length;
        int res = Integer.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        A = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        seq = new int[A];
        length = new int[A];

        for (int i = 0; i < A; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < A; i++) {
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
            res = Math.max(length[i], res);
        }

        System.out.println(res);
    }
}
