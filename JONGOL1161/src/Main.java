import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * JONGOL1161
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);
    }

    public static void hanoi(int count, int from, int to, int x) {
        if(count == 1) {
            System.out.println(count + " : " + from + " -> " + to);
            return;
        }

        hanoi(count-1, from, x, to);
        System.out.println(count + " : " + from + " -> " + to);
        hanoi(count-1, x, to, from);
    }
}
