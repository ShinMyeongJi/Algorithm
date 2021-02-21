import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        int cnt = 0;
        int series = 0;
        while(true) {
            series++;

            if(Integer.toString(series).contains("666")){
                cnt++;
            }

            if(cnt == N) break;
        }
        System.out.println(series);
    }
}
