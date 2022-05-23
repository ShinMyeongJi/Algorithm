import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[][] item = {{1,60,10}, {2,100,20}, {3,120,30}};
        int limit = 50; //배낭의 제한 무게

        // 무게 대비 가치 순으로 정렬
        Arrays.sort(item, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int prev = o1[1]/o1[2];
                int cur = o2[1]/o2[2];

                if (cur - prev> 0) {
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        int res = 0;

        for (int i = 0;i < item.length; i++) {

            if(limit > 0) {
                if (limit > item[i][2]) {
                    limit -= item[i][2];
                    res += item[i][1];
                }else {
                    res += (item[i][1]/item[i][2] * limit);
                    limit = 0;
                }
            }else {
                break;
            }
        }

        System.out.println(res);

    }
}
