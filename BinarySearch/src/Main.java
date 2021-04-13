import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        QN = Integer.parseInt(br.readLine());
        int[] qVals = new int[QN];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < QN; i++) {
            qVals[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < QN; i++) {
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

    private static int binarySearch2(int[] arr, int low, int high, int target){
        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}







