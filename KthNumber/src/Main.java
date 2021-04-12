import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int N = 3;
        int[] array = new int[]{1,10,101,61,45};
        int[][] commands = new int[][]{
            {2, 5, 4}, {4, 4, 1}, {1, 3, 3}, {2, 4, 1}
        };

        int[] res = new int[commands.length];
        List<Integer> sorting = new ArrayList<>();
        for(int i = 0; i < commands.length; i++) {

            for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                sorting.add(array[j]);
            }
            Collections.sort(sorting);
            res[i] = sorting.get(commands[i][2] - 1);
            sorting.clear();
        }

        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
