import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int ln = 0;
        int n = 0;
        String str = "";

        Scanner kb = new Scanner(System.in);
        ln = kb.nextInt();


        for(int i = 0; i < ln; i++) {
            n = kb.nextInt();
//          method2!
            //       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //      str = br.readLine();
            str = kb.next();


            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
