
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName :  PACKAGE_NAME
 * fileName : Main
 * author :  shinmj
 * date : 22. 10. 12.
 * description :
 */
public class Main {
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map;

        int cnt = 0;
        boolean isGroup;
        while (N-- > 0) {
            String s = br.readLine();
            isGroup = true;
            map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                if (map.containsKey(c)) {
                    if (c == s.charAt(i-1)) {
                        map.computeIfPresent(c, (k, v) -> v + 1);
                    }else{
                        isGroup = false;
                        break;
                    }
                }else {
                    map.put(c, 1);
                }
            }

            if (isGroup) cnt++;

        }

        System.out.println(cnt);

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
