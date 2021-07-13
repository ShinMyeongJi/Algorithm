import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        System.out.println(stringsInMaxDepth("((AAX(AB)(UP)F(Z))(HH))"));
    }

    public static List<String> stringsInMaxDepth(String s) {
        List<String> res = new ArrayList<>();

        int curMax = 0;
        int maxDepth = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                curMax++;
                if(maxDepth < curMax) maxDepth = curMax;
            }
            else if(s.charAt(i) == ')') curMax--;
        }

        curMax = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {

            if(curMax == maxDepth) {
                sb.append(s.charAt(i));
                if(s.charAt(i + 1) == ')') {
                    res.add(sb.toString());
                    sb = new StringBuffer();
                }
            }

            if(s.charAt(i) == '(') curMax++;
            else if(s.charAt(i) == ')') curMax--;
        }

        System.out.println(res.toString());

        return res;
    }
}
