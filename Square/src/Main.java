import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[] x = new int[3];
        int[] y = new int[3];

        int resultX = 0, resultY = 0;

        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            x[i] = keyboard.nextInt();
            if(x[i] < 1 || x[i] > 1000) return;
            y[i] = keyboard.nextInt();
            if(y[i] < 1 || y[i] > 1000) return;

        }

        for(int i = 1; i < 3; i++) {
            if(x[0] == x[i]){
                if(i == 1) resultX = x[2];
                else resultX = x[1];
                break;
            }
            resultX= x[0];
        }

        for(int i = 1; i < 3; i++) {
            if(y[0] == y[i]){
                if(i == 1) resultY = y[2];
                else resultY = y[1];
                break;
            }
            resultY = y[0];
        }

        System.out.println(resultX + " " + resultY);
    }
}
