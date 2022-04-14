import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

// 다른 풀이 체크하기
// https://programmers.co.kr/learn/courses/30/lessons/42888/solution_groups?language=java

class Solution {
    public String[] solution(String[] record) {
        StringTokenizer st;
        HashMap<String, String> nickHash = new HashMap<>();
        List<String> log = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);

            String command = st.nextToken();
            String id = st.nextToken();
            String nickname = "";

            if (!command.equals("Leave")) {
                nickname = st.nextToken();
            }

            switch (command) {
                case "Enter" : {
                    nickHash.put(id, nickname);
                    log.add(id + "님이 들어왔습니다.");
                    break;
                }
                case "Leave" : {
                    log.add(id + "님이 나갔습니다.");
                    break;
                }
                case "Change" : {
                    String prevNick = nickHash.get(id);
                    nickHash.replace(id, prevNick, nickname);
                    break;
                }
            }


        }

        String[] answer = new String[log.size()];

        for (int i = 0; i < answer.length; i++) {
            String msg = log.get(i);
            int idx = msg.indexOf("님");
            String prevUpdated = msg.substring(0, idx);

            answer[i] = msg.replace(prevUpdated, nickHash.get(prevUpdated));
        }

        return answer;
    }

}
