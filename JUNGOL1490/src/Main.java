import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * JONGOL 1490
 */
public class Main {
    private static int N, K; // 1~N 까지 N 개 중 K 개 뽑기
    private static int[] arr;
    private static boolean[] chks;
    private static List<String> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String findStr = br.readLine();

        arr = new int[N];
        chks = new boolean[N];
        res = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        combination(0, 0);
        if(res.indexOf(findStr) == res.size() - 1 || res.size() == 1) {
            System.out.println("NONE");
        }else{
            System.out.println(res.get(res.indexOf(findStr.trim()) + 1));
        }
    }

    public static void combination(int line, int step) {
        if(step >= K) {
            String str = "";
            for(int i = 0; i < N; i++) {
                if(chks[i]) str += arr[i] + " ";
            }
            res.add(str.trim());
            return;
        }
        for(int i = line; i < N; i++) {
            chks[i] = true;
            combination(i + 1, step + 1);
            chks[i] = false;
        }
    }
}
