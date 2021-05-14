import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int P;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();


        findRules(N * N % P);
    }

    public static void findRules(int r) { // 나머지 계산
        if(list.indexOf(r) != -1) {
            if(list.size() == list.indexOf(r) + 1) System.out.println(1);
            else System.out.println(list.size());
            return;
        }

        list.add(r);
        findRules(r * N % P);
    }
}
