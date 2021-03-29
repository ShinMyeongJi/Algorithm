import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * JONGOL 2259
 */
public class Main {
    public static final int SIZE = 6;
    public static void main(String[] args) throws IOException {
        int area = 0;

        int[] direction = new int[SIZE];
        int[] length = new int[SIZE];
        int[] areasOfPart = new int[SIZE]; // 각 부분들의 합
        int maxHor = Integer.MIN_VALUE; // 가장 긴 가로 길이
        int maxVer = Integer.MIN_VALUE; // 가장 긴 세로 길이
        int sumOfParts = 0;

        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        area = Integer.parseInt(bw.readLine());

        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(bw.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < SIZE - 1; i++) {
            areasOfPart[i] = length[i] * length[i + 1];
        }
        areasOfPart[SIZE - 1] = length[0] * length[SIZE - 1];


        for(int i = 0; i < SIZE; i++) {
            if((direction[i] == 1 || direction[i] == 2) && maxHor < length[i]) {
               maxHor = length[i];
            }else if((direction[i] == 3 || direction[i] == 4) && maxVer < length[i]){
               maxVer = length[i];
            }
            sumOfParts += areasOfPart[i];
        }

        System.out.println((sumOfParts - (maxHor * maxVer * 2)) * area);
    }
}
