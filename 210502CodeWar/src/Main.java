import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 210502
 * Code War - Most frequently used words in a text
 *
 * 하..^^.. 진짜 뭐가 문젠데
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(top3("  //wont won't won't ").getClass());
    }

    public static List<String> top3(String str) {
        final Map<String, Integer> wordsCount = new HashMap<>();

        Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z']*");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String s = matcher.group().toLowerCase();
            wordsCount.put(s, wordsCount.getOrDefault(s, 1) + 1);
        }

        List<Map.Entry<String, Integer>> topWords = new ArrayList<>(wordsCount.entrySet());
        topWords.sort(Map.Entry.comparingByValue());
        ArrayList<String> result = new ArrayList<>();
        int j = 0;
        for (int i = topWords.size() - 1; i >= 0; i--) {
            String s = topWords.get(i).getKey();
            if (j > 2 || s == null || s.length() == 0) {
                break;
            }
            if (Character.isAlphabetic(s.charAt(0))) {
                result.add(j, topWords.get(i).getKey());
                j++;
            }
        }

        result.trimToSize();
        return result;

        /*String[] words = s.toLowerCase().replaceAll("[^\\w\\s\']","").trim().split("\\s+");
        Map<String, Integer> countChks = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!countChks.containsKey(words[i])) countChks.put(words[i], 1);
            else {
                countChks.put(words[i], countChks.get(words[i]) + 1);
            }
        }

        List<String> keys = new ArrayList<>();
        List<String> result = new ArrayList<>();

        keys.addAll(countChks.keySet());

        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer v1 = countChks.get(o1);
                Integer v2 = countChks.get(o2);

                return v2.compareTo(v1);
            }
        });

        if(countChks.size() < 3) {
            for(int i = 0; i < keys.size(); i++) result.add(keys.get(i));
        }else{
            for(int i = 0; i < 3; i++) {
                result.add(keys.get(i));
            }
        }

        return result;*/
    }
}
