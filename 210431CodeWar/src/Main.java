/**
 * Code War - Split String
 * 정규식으로 풀어보기
 */


public class Main{
    public static void main(String[] args) {
        String[] ss = solution("abcde");
        for(int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }

    public static String[] solution(String s) {
        s = (s.length() % 2 == 0) ? s : s+"_";
        return s.split("(?<=\\G.{2})");
        /**
         * 후방탐색 : ?<=
         *
         */

    }
}


/*public class Main {

    public static void main(String[] args) {

        String[] ss = solution("abcde");
        for(int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }

    public static String[] solution(String s) {
        //Write your code here
        String[] strs;
        if(s.length() % 2 == 0) strs = new String[s.length()/2];
        else strs = new String[s.length()/2 + 1];

        for(int i = 0; i < s.length(); i+=2) {
            String newstr = s.charAt(i) + "";
            if(s.length() % 2 != 0) {
                if(i == s.length() - 1){
                    newstr += "_";
                }else{
                    newstr += s.charAt(i+1);
                }
            }else{
                newstr += s.charAt(i+1);
            }
            strs[i/2] = newstr;
        }
        return strs;
    }
}
*/