import java.io.*;
import java.util.Scanner;

/**
 * BOJ 2231
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int N = 0;
        int res = 0;

        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= N; i++){
            int sum = i;
            int ext = i;
            while(ext != 0){
                sum += ext % 10;
                ext = ext / 10;
            }

            if(sum == N) {
                res = i;
                break;
            }
        }

        bw.write(((Integer) res).toString());

        bw.flush();
        bw.close();
    }
}
