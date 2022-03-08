import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int A;
        int[] seq;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        A = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        seq = new int[A];

        for (int i = 0; i < A; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

    }
}
