import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quick(arr, 0, N - 1);

    }

    public static void quick(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        print();
        while(left <= right) {
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            if(left <= right) swap(arr, left, right);
        }

        if(start <= end) {
            swap(arr, start, right);
            quick(arr, start, right - 1);
            quick(arr, right + 1, end);
        }

    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void print() {
        for(int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
