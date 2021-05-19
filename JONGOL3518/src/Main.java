import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quick(arr, 0, N - 1);

        for(int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }

    public static void quick(int[] arr, int low, int high) {
        if(low < high) {
            int i = low - 1;
            int pivot = arr[high];

            for(int j = low; j < high; j++) {
                if(arr[j] < pivot) {
                    swap(arr[++i], arr[j]);
                }
            }

            swap(arr[++i], arr[high]);

            quick(arr, low, i - 1);
            quick(arr, i + 1, high);
        }
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

}
