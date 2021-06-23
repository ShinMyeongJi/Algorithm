import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Code Wars Scramblies
public class Main {
    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world"));
    }

    public static boolean scramble(String str1, String str2) {
        List<Character> list = new ArrayList(Arrays.asList(str1.split("(?!^)")));

        for(int i = 0; i < str2.length(); i++) {
            int idx = list.indexOf(str2.charAt(i) + "");
            if(idx == -1) return false;
            list.remove(idx);
        }

        return true;
        // your code
    }
}
