import java.io.*;
import java.util.StringTokenizer;

/**
 * JONGOL 3517
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        int QN = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] sortedArr = new int[N];
        String[] temp1 = br.readLine().split(" ");
        QN = Integer.parseInt(br.readLine());
        int[] qVals = new int[QN];
        String[] temp2 = br.readLine().split(" ");


        for(int i = 0; i < N; i++) {
            sortedArr[i] = Integer.parseInt(temp1[i]);
        }
        for(int i = 0; i < QN; i++) {
            qVals[i] = Integer.parseInt(temp2[i]);
            sb.append(binarySearch(sortedArr, 0, N - 1, qVals[i]));
            if(i != QN - 1) sb.append(" ");
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        if(low > high) return -1;

        int mid = (low + high) / 2;

        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) return binarySearch(arr, low, mid-1 ,target);
        else return binarySearch(arr, mid + 1, high, target);
    }

}







