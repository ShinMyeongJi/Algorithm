import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
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
        
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < course.length; i++) {

        }

        return answer;
    }

    public void combination(String order, int r, int cnt) {

    }
}
