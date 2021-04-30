import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * JONGOL 2817
 * 조합 문제
 * 백트래킹과 재귀
 */
public class Main {
    private static int K;
    private static int[] inputs;
    private static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        inputs = new int[K];
        check = new boolean[K];
        for(int i = 0; i < K; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        print(0, 0);
    }

    private static void print(int line, int step) {
        if(step >= 6) {
            for(int i = 0; i < K; i++) {
                if(check[i])
                    System.out.print(inputs[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = line; i < K; i++) {
            check[i] = true;
            print(i + 1, step + 1);
            check[i] = false;
        }
    }

}
