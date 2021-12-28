import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N = 0;
    static int[] num;
    static int[] operations = new int[4];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }


        DFS(num[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void DFS(int num, int count) {
        if(count == N) {
            if(num < MIN) MIN = num;
            if(num > MAX) MAX = num;
            return;
        }

        for (int i = 0; i < 4; i++) {

        }
    }
}
