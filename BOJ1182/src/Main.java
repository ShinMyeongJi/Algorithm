import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i  = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }



}
