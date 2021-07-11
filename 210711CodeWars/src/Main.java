import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        System.out.println(inArray(a, b));
    }

    public static String[] inArray(String[] array1, String[] array2) {
        ArrayList<String> res = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array2.length; j++) {
                if(array2[j].contains(array1[i])) {
                    if(!res.contains(array1[i])) res.add(array1[i]);
                }
            }
        }
        Collections.sort(res);

        return res.stream().toArray(String[]::new);
    }


    /**
     * 람다식으로 줄이기
     *
     * return Arrays.stream(array1)
     * .filter(str -> Arrays.stream(array2).anyMatch(s -> s.contains(str))) // anyMatch
     * .distinct() // 중복제거
     * .sorted()
     * .toArray(String[]::new);
     *
     */
}
