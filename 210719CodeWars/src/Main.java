import java.util.ArrayList;
import java.util.List;

/**
 * 210719 CodeWars - Consecutive strings
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(longestConsec(new String[] {"wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"}, 2));
    }

    public static String longestConsec(String[] strarr, int k) {
        // your code
        if(k <= 0 || k > strarr.length || strarr.length == 0) return "";

        List<String> concats = new ArrayList<>();
        String max = "";
        for (int i = 0; i <= strarr.length - k; i++) {
            StringBuffer sb = new StringBuffer();
            for(int j = i; j < i + k; j++) {
                sb.append(strarr[j]);
            }
            concats.add(sb.toString());
        }

        for(int i = concats.size()-1; i >= 0; i--) {
            if(max.length() <= concats.get(i).length()) max = concats.get(i);
        }

        return max;
    }
}

/*
* Stream 으로 하기
*  if (k <= 0) {
            return "";
        }

        return IntStream.rangeClosed(0, strarr.length - k) // rangeClosed -> 끝 값 포함
                .mapToObj(i -> Arrays.stream(strarr, i, i + k).collect(Collectors.joining()))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
*
*/