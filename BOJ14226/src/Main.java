import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int S;
    static int clipboard = 0;

    //static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());

        dfs(1, 0);
    }

    public static void dfs(int cnt, int second) {
        if (cnt == S) {
            System.out.println(second);
            return;
        }


        clipboard = cnt;
        dfs(cnt, second + 1);

        if (clipboard != 0) {
            dfs(clipboard, second + 1);
        }

        dfs(cnt - 1, second + 1);
    }
}
