import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : PACKAGE_NAME
 * fileName       : Main3
 * author         : home
 * date           : 22. 10. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 22. 10. 21.        home       최초 생성
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        int n, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] values = new int[n];
        int[] sum = new int[k + 1];

        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        sum[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if(j - values[i] >= 0) {
                    sum[j] = sum[j] + sum[j - values[i]];
                }
            }

        }

        System.out.println(sum[k]);
    }
}
