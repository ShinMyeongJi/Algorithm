import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 0;
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        String[][] infos = new String[N][2];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++) {
                infos[i][j] = kb.next();
            }
        }


        Arrays.sort(infos, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0]));
            }
        });


        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++) {
                System.out.print(infos[i][j] + " ");
            }
            System.out.println();
        }
    }
}
