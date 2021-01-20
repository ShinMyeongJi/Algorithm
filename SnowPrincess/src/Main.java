import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        List<Integer> arr = new ArrayList<>();
        int sumInt = 0;

        Scanner kb = new Scanner(System.in);

        for(int i = 0; i < 9; i++){
            arr.add(kb.nextInt());
        }

        sumInt = sum(arr);
        int one= 0, two = 0;

        loop:
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 9; j++) {
                int res = 0;
                res = sumInt - (arr.get(i) + arr.get(j));

                if(res == 100) {
                    one = i;
                    two = j;
                    break loop;
                }
            }

        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
            if(i != one && i != two) {
                result.add(arr.get(i));
            }
        }

        Collections.sort(result);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

    }

    public static int sum(List<Integer> arr){
        int res = 0;
        for(int i = 0; i < arr.size(); i++) {
            res += arr.get(i);
        }
        return res;
    }
}
