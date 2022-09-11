import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  shinmj
 * date : 22. 10. 16.
 * description :
 */
public class Main {

    static int N;
    //static int minSeq = Integer.MAX_VALUE;

    static String minSeq = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs("");

        System.out.println(minSeq);

    }

    public static void dfs(String seq) {
        if(minSeq != "") return;
        //아.. 이걸로 최소를 판단하는구나;;;;;;;;;;


        //N이 80까지니까...아무래도 integer로 변환할 수가 없자나
        if (seq.length() == N) {// && isGood(seq)) {

            minSeq = seq;
            //if (minSeq > Integer.parseInt(seq)) {
            //    minSeq = Integer.parseInt(seq);
                //result = seq;
            //}
            return;
        }


        for (int i = 1; i <= 3; i++) {
            if (isGood(seq + i)) {
                dfs(seq + i);
            }
        }
    }


    public static boolean isGood(String seq) {
        // 좋은 수열인지 판단
        // 판단 어떻게?
        // 인접 수열이라 했으니까 비교해야하는 숫자열의 길이는 문자 1개씩 부터 ~ length/2까지...

        for(int i = 1; i <= seq.length()/2; i++) {
            for (int j = 0; j <= seq.length() - i*2; j++) {
                int k = j + i;

                String str1 = seq.substring(j, k);
                String str2 = seq.substring(k, k + i);

               // System.out.println(str1 + " / " + str2);

                if (str1.equals(str2)) return false;
            }
        }

        return true;

    }
}
