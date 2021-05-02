import java.util.*;

/**
 * 210502
 * Code War - Most frequently used words in a text
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(top3("a a a  b  c c  d d d d  e e e e e"));
    }

    public static List<String> top3(String s) {
        String[] words = s.split("\\s+");
        SortedMap<String, Integer> countChks = new TreeMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!countChks.containsKey(words[i])) countChks.put(words[i], 1);
            else {
                countChks.put(words[i], countChks.get(words[i]) + 1);
            }
        }

        List<String> result = new ArrayList<>();
        System.out.println(countChks);
        Object[] keys = countChks.keySet().toArray();
        for(int i = keys.length-1; i >= keys.length-3; i--) {
            result.add((String) keys[i]);
        }
        return result;
    }
}
