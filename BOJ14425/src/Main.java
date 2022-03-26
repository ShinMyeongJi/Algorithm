import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.get(str) != null) cnt++;
        }

        System.out.println(cnt);
    }
}

class TrieNode {
    Map<Character, TrieNode> childNode = new HashMap<>();
    boolean isLastChar;

    public void insert(String word) {

    }
}

