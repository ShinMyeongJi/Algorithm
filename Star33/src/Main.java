import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * BOJ 2447 번
 */
public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        int N;
        Scanner kb = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = kb.nextInt();

        stars = new char[N][N];

        makeStars(0, 0, N, false);


        for(int i = 0; i < N; i++){
            bw.write(stars[i]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void makeStars(int x, int y, int N, boolean blank){
        if(blank){
            for(int i = x; i < x + N; i++){
                for(int j = y; j < y + N; j++){
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        if(N == 1){
            stars[x][y] = '*';
            return;
        }

        int size = N / 3;
        int count = 0;

        for(int i = x; i < x+N; i+=size){
            for(int j = y; j < y+N; j+=size){
                count++;

                if(count == 5){
                    makeStars(i, j, size, true);
                }else{
                    makeStars(i, j, size, false);
                }
            }
        }
    }
}
