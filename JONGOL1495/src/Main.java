import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr1 = new int[N];
        arr2 = new int[N];

        for(int i = 0; i < N; i++) {
            arr1[i] = i;
            arr2[i] = Integer.parseInt(br.readLine());
        }



    }

    public static void pick(int step) {

    }


}
