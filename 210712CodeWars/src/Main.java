/**
 * CodeWars Reverse or rotate?
 * 문자열을 sz 크기의 chunk로 나눠 아래 연산을 수행한다.
 * 1. 문자열의 총 합이 짝수면 숫자열 뒤집기 ex) 123 -> 321
 * 2. 문자열의 합이 홀수면 왼쪽으로 한칸이동 ex) 123 -> 231
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(revRot("733049910872815764", 5));
    }

    public static String revRot(String strng, int sz) {
        if(sz <= 0 || sz > strng.length()) return "";

        String[] strs = strng.split("(?<=\\G.{" + sz + "})");

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < strs.length; i++) {
            int sum = 0;

            for(int j = 0; j < strs[i].length(); j++) {
                if(strs[i].length() != sz) {
                    strs[i] = "";
                    continue;
                }
                sum += Integer.parseInt(String.valueOf(strs[i].charAt(j)));
            }

            //짝수일 경우
            if(sum % 2 == 0) {
                for (int j = strs[i].length() - 1; j >= 0; j--)
                    sb.append(strs[i].charAt(j));
            }else{ // 홀수일 경우
                sb.append(strs[i].substring(1)).append(strs[i].charAt(0));
            }
        }

        return sb.toString();
    }
}
