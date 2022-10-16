import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  home
 * date : 22. 10. 16.
 * description :
 */
public class Main {

    static int N;
    static int minSeq;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0, "");

        /*String str = "1232123";

        int i = 3;
        int j = 1;
        System.out.println(str.substring(j, i + j) + ", "  + str.substring(i + j, i + j + i));*/

        System.out.println(result);

    }

    public static void dfs(int cnt, String seq) {
        if (cnt == N) {// && isGood(seq)) {
            if (minSeq > Integer.parseInt(seq)) {
                minSeq = Integer.parseInt(seq);
                result = seq;
            }
            return;
        }


        for (int i = 0; i < 3; i++) {
            if (isGood(seq += i)) {
                dfs(cnt + 1, seq += i);
            }
        }
    }


    public static boolean isGood(String seq) {
        // 좋은 수열인지 판단
        // 판단 어떻게?
        // 인접 수열이라 했으니까 비교해야하는 숫자열의 길이는 문자 1개씩 부터 ~ length/2까지...

        for(int i = 1; i < seq.length()/2; i++) {
            for (int j = 0; j < seq.length(); j++) {
                int k = j + i;

                String str1 = seq.substring(j, k);
                String str2 = seq.substring(k, k + i);

                if (str1.equals(str2)) return true;
            }
        }

        return false;

    }
}
