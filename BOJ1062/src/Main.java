import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * BOJ 1062
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        int K = 0;
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String[] words = new String[N];

        for(int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Vector<String> alphabets = new Vector<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                String temp = Character.toString(words[i].charAt(j));
                if(alphabets.indexOf(temp) == -1) alphabets.add(temp);
            }
            if(alphabets.size() < K) cnt++;
            System.out.println(alphabets.size());
            alphabets.clear();
        }


        System.out.println(cnt);
    }
}
/**
 * a, n, t, i, c 는 필수적으로 들어가는 알파벳이므로 이것보다 작은 수가 입력되면 아예 읽을 수가 없는 것..
 */
