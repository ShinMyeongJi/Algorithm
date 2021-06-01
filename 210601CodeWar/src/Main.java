public class Main {
    public static void main(String[] args) {
        int[][] res = createSpiral(5);
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] createSpiral(int N) {
        int[][] res = new int[N][N];

        int roundCnt = N;
        int d = 1;
        int x = 0;
        int y = -1;
        int cnt = 1;
        while(roundCnt != 0) {
            for (int i = 0; i < roundCnt; i++) {
                y += d;
                res[x][y] = cnt;
                cnt++;
            }
            roundCnt--;
            for(int i = 0; i < roundCnt; i++) {
                x += d;
                res[x][y] = cnt;
                cnt++;
            }

            d *= -1;
        }

        return res;
    }
}
