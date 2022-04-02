import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> orders = new ArrayList<>();
        List<Integer> courses = new ArrayList<>();

        while (st.hasMoreTokens()) {
            orders.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            courses.add(Integer.parseInt(st.nextToken()));
        }

        String[] result = solution(orders.toArray(new String[orders.size()]), courses.toArray(new Integer[courses.size()]));

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        /*List<String> list = new Solution().solution(orders.toArray(new String[orders.size()]), courses.toArray(new Integer[courses.size()]));
        System.out.println(Arrays.toString(list.toArray(new String[list.size()])));*/
    }

    public static String[] solution(String[] orders, Integer[] course) {


        List<String> list = new ArrayList<>();

        // 1. 조합 작업을 위해 각 문자열 오름차순 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();

            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }


        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();

            int max = Integer.MIN_VALUE;

            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if (course[i] <= orders[j].length()) {
                    combination(sb, orders[j], course[i], 0, 0);
                }
            }

            for (String s : map.keySet()) {
                max = Math.max(max, map.get(s));
            }

            for (String s : map.keySet()) {
                if (max >= 2 && map.get(s) == max) {
                    list.add(s);
                }
            }
        }

        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }

    public static void combination(StringBuilder sb, String order, int r, int cnt, int idx) {
        if(cnt == r) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1); // 해당 문자열이 없으면 0으로 요소 추가
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combination(sb, order, r, cnt + 1, i + 1);
            sb.delete(cnt, cnt + 1);
        }
    }
}

class Solution {

    // 12. combi 메소드에서 map에 접근하기 위해 전역변수로 선언.
    static HashMap<String,Integer> map;
    // 13. 조합을 구하는 메소드 (한 사람의 메뉴구성, 조합을 구할 StringBuilder, 조합을 위한 idx, 코스요리 개수에 따른 종료조건을 위한 cnt와 n)
    public static void combi(String str,StringBuilder sb,int idx, int cnt, int n){
        // 14. 각 코스요리의 개수만큼 조합이 되면,
        if(cnt == n) {
            // 15. map에 해당 조합을 삽입 및 카운팅.
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }

        // 16. idx부터 시작함으로써 조합을 구할 수 있다.
        for(int i = idx ; i<str.length();i++){
            // 17. sb에 붙여나간다.
            sb.append(str.charAt(i));
            // 18. 재귀호출.
            combi(str,sb,i+1,cnt+1,n);
            // 19. 붙였던거 다시 떼기.
            sb.delete(cnt,cnt+1);
        }
    }

    public ArrayList<String> solution(String[] orders, Integer[] course) {
        ArrayList<String> answer = new ArrayList<>();

        // 1. 각 문자열을 오름차순 정렬.
        for(int i =0;i<orders.length;i++){
            // 2. 각 문자열을 문자형 배열로 변환.
            char[] charArr = orders[i].toCharArray();
            // 3. 해당 문자형 배열을 정렬.
            Arrays.sort(charArr);
            // 4. 정렬된 문자형 배열을 문자열로 변환해 저장.
            orders[i] = String.valueOf(charArr);
        }

        // 5. course의 길이만큼 반복하여 필요한 조합을 구함.
        for(int i =0;i<course.length;i++){
            // 6. HashMap으로 조합의 수를 카운팅.
            map = new HashMap<>();
            // 7. course의 경우에 따라 구한 조합들 중 가장 많이 주문된 횟수를 저장.
            int max = Integer.MIN_VALUE;
            // 8. 각 사람들의 조합을 구하기 위해 탐색.
            for(int j =0;j<orders.length;j++){
                // 9. 조합을 구하기 위해 문자열을 조작할 StringBuilder.
                StringBuilder sb = new StringBuilder();
                // 10. 코스의 개수 <= 각 문자열의 길이인 경우 조합을 구한다.
                if(course[i]<=orders[j].length())
                    // 11. 조합을 구하기 위한 메소드 호출
                    combi(orders[j],sb,0,0,course[i]);
            }

            // 20. 가장 많이 주문된 횟수를 max에 저장.
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());

            }
            // 21. 최소 2번 이상 주문된 조합이며, 해당 횟수와 일치하는 조합은 ArrayList에 삽입.
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }
        // 22. 추가된 조합들을 오름차순 정렬.
        Collections.sort(answer);

        return answer;
    }
}