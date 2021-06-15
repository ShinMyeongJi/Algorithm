import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);

    }

    public static void mergeSort(int start, int end) {

        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while(p <= mid || q <= end) {
                if(q > end || (p<=mid && arr[p] < arr[q])) {
                    temp[idx++] = arr[p++];
                }else{
                    temp[idx++] = arr[q++];
                }
            }

            for(int i = start; i <= end; i++) {
                arr[i] = temp[i];
            }
            print();

        }

    }

    public static void print() {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
