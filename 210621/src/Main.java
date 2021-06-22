//https://programmers.co.kr/learn/courses/30/lessons/12973
//테스트 케이스는 all success but, 시간초과^^..
public class Main {
    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s)
    {
        StringBuffer sb;
        while(check(s)) {
            for(int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    sb = new StringBuffer(s);
                    sb.replace(i, i+2, "");
                    s = sb.toString();
                }
            }
        }

        if(s.equals("")) return 1;
        return 0;
    }

    public static boolean check(String s) {
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) return true;
        }
        return false;
    }
}
