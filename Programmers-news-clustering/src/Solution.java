import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public int solution(String str1, String str2) {
        Matcher matcher;
        String pattern = "[^a-zA-Z]";

        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String part = str1.substring(i, i+2);
            matcher = Pattern.compile(pattern).matcher(part);

            if (matcher.find()) continue;

            str1List.add(part);
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String part = str2.substring(i, i+2);
            matcher = Pattern.compile(pattern).matcher(part);

            if (matcher.find()) continue;

            str2List.add(part);
        }

        for (String s : str1List) {
            if (str2List.remove(s)) {
                intersection.add(s);
            }

            union.add(s);
        }

        for (String s : str2List) {
            union.add(s);
        }


        if (union.size() != 0) {
            answer = (int)(((double)intersection.size() / union.size()) * 65536);
        }else{
            answer = 1 * 65536;
        }

        return answer;
    }
}
