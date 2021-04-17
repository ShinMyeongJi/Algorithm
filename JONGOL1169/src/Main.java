import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if(M == 1) dice1(N);
        else if(M == 2) dice2(N);
        else if(M == 3) dice3(N);
    }

    public static void dice1(int N) {

    }

    public static void dice2(int N) {

    }

    public static void dice3(int N) {

    }
}
