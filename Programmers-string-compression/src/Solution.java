public class Solution {
    public int solution(String s) {

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length() / 2; i++) {
            min = Math.min(compression(i, s).length(), min);
        }

        return min;
    }

    public String compression(int unit, String s) {
        int count = 1;
        String makedCompression = "";
        String prevStr = "";

        //double repeat = Math.ceil((double)s.length() / unit);
        for (int i = 0; i <= s.length() + unit; i += unit) {
            String pstr;

            if (i >= s.length()) {
                pstr = "";
            } else if (i + unit > s.length()) {
                pstr = s.substring(i);
            }else{
                pstr = s.substring(i, i + unit);
            }

            if (i != 0) {
                if (prevStr.equals(pstr)) {
                    count++;
                }else if(count >= 2){
                    makedCompression += count + pstr;
                    count = 1;
                }else {
                    makedCompression += pstr;
                }
            }

            prevStr = pstr;
        }

        System.out.println(makedCompression);
        return makedCompression;
    }
}
