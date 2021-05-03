import java.util.*;

/**
 * 210503
 * Code Wars - Twice linear
 *
 * SortedSet의 특징
 * Set은 중복을 허용하지 않으면서 저장 순서를 유지한다.
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(dblLinear(50));

    }
    public static int dblLinear (int n) {
        SortedSet<Integer> list = new TreeSet<>();
        list.add(1);

        for(int i = 0; i < n; i++) {
            int x = list.first();

            list.add(2 * x + 1);
            list.add(3 * x + 1);

            list.remove(list.first());
        }

        return list.first();
    }

}
