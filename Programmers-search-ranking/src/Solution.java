import java.util.*;

class Solution {

    Map<String, List<Integer>> allCases = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            makeAllCases("", 0, info[i].split(" ")); // 현재까지 만들어진 문자열, 현재 인덱스, info 배열
        }

        for (String s : allCases.keySet()) {
            Collections.sort(allCases.get(s));
        }


        for(int i = 0; i < query.length; i++) {
            String removedAndQuery = query[i].replace(" and ", "");
            String[] keyAndValue = removedAndQuery.split(" ");
            int caseRes = allCases.containsKey(keyAndValue[0]) ? binarySearch(keyAndValue[0], Integer.parseInt(keyAndValue[1])) : 0;
            res.add(caseRes);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    // 해당 info가 가질 수 있는 모든 조합 : key, 그 조건을 가진 점수 : value 로 map을 구성한다.
    public void makeAllCases(String curStr, int cnt, String[] infos) {

        if (cnt == 4) {
            if (!allCases.containsKey(curStr)){
                List<Integer> list = new ArrayList<>();
                allCases.put(curStr, list);
            }
            allCases.get(curStr).add(Integer.parseInt(infos[4]));
            return;
        }

        makeAllCases(curStr + infos[cnt], cnt + 1, infos);
        makeAllCases(curStr + "-", cnt + 1, infos);
    }

    // 이진탐색
    // 주의할 점 : 이진 탐색을 하면서 앞 뒤의 범위를 좁히는 것이 아니라 그 찾아진 idx로 몇 개의 요소가 남아있는지를 알아내기 위함이기 때문에 맨 뒤의 범위(high)가 줄어들면 안 된다.
    public int binarySearch(String key, int value) {
        List<Integer> scores = allCases.get(key);

        int low = 0;
        int high = scores.size() -1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (scores.get(mid) < value) low = mid + 1;
            else high = mid - 1;
        }

        return scores.size() - low;
    }

//[50, 80, 150, 150, 210, 260]

}