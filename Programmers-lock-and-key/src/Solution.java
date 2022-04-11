class Solution {

    public boolean solution(int[][] key, int[][] lock) {

        int newLockSize = (key.length - 1) * 2 + lock.length;

        for(int i = 0; i < newLockSize; i++) {
            for(int j = 0; j < newLockSize; j++) {

                // 회전
                for (int k = 0; k < 4; k++) {
                    int[][] newLock = new int[newLockSize][newLockSize];

                    for (int l = 0; l < lock.length; l++) {
                        for (int m = 0; m < lock.length; m++) {
                            newLock[key.length - 1 + l][key.length - l + m] = lock[l][m];
                        }
                    }

                    /*for (int l = 0; l < key.length; l++) {
                        for (int m = 0; m < key.length; m++) {
                            newLock[m][key.length - 1 - l] = key[l][m];
                        }
                    }*/

                    match(newLock, key, k, i, j);
                    if (check()) return true;

                }
            }
        }

        return false;
    }

    public void match(int[][] newLock, int[][] key, int rot, int y, int x) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (rot == 0) {

                }
            }
        }
    }

    public boolean check() {
        return false;
    }
}
