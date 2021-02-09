import java.util.Scanner;

/**
 * BOJ7568
 */
public class Main {
    public static void main(String[] args){
        int N = 0;
        String data;

        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        int[][] dungcci = new int[N][2];
        int[] counts = new int[N];

        for(int i = 0; i < N; i++){
           dungcci[i][0] = kb.nextInt();
           dungcci[i][1] = kb.nextInt();
        }


        for(int i = 0; i < N; i++){
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(dungcci[i][0] < dungcci[j][0] && dungcci[i][1] < dungcci[j][1]){
                    count++;
                }
            }

            counts[i] = count;
        }

        for(int i = 0; i < N; i++){
            System.out.println(counts[i] + 1);
        }
    }


}
