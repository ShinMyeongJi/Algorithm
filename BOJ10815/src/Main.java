import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] checkCards = new int[M];
        for (int i = 0; i < M; i++) {
            checkCards[i] = Integer.parseInt(st.nextToken());
            System.out.print(binarySearch(checkCards[i]) + " ");
        }
    }

    public static int binarySearch(int target) {
        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (cards[mid] < target) low = mid + 1;
            else if (cards[mid] == target) return 1;
            else high = mid - 1;
        }

        return 0;
    }
}
