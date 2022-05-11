import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, S, R;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        List<Integer> sList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < S; i++){
            sList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < R; i++) {
            rList.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {

        }

    }
}
