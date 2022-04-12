class Solution {

    public boolean solution(int[][] key, int[][] lock) {

        int newLockSize = (key.length - 1) * 2 + lock.length;

        for(int i = 0; i < key.length - 1 + lock.length; i++) {
            for(int j = 0; j < key.length - 1 + lock.length; j++) {

                // 회전
                for (int k = 0; k < 4; k++) {
                    int[][] newLock = new int[newLockSize][newLockSize];

                    for (int l = 0; l < lock.length; l++) {
                        for (int m = 0; m < lock.length; m++) {
                            newLock[key.length - 1 + l][key.length - 1 + m] = lock[l][m];
                        }
                    }

                    match(newLock, key, k, i, j);

                   /* System.out.println("==================");
                    for (int a = 0; a < newLockSize; a++) {
                        for (int b = 0; b < newLockSize; b++) {
                            System.out.print(newLock[a][b] + " ");
                        }
                        System.out.println();
                    }*/
                    if (check(newLock, key.length - 1, lock.length)) return true;

                }
            }
        }

        return false;
    }

    public void match(int[][] newLock, int[][] key, int rot, int y, int x) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (rot == 0) { // 회전하지 않았을 때
                    newLock[y + i][x + j] += key[i][j];
                }else if(rot == 1) { // 90도 회전
                    newLock[y + i][x + j] += key[j][key.length - i - 1];
                }else if(rot == 2) { // 180도 회전
                    newLock[y + i][x + j] += key[key.length - i - 1][key.length - j - 1];
                }else { // 270도 회전(왼쪽으로 90도 회전)
                    newLock[y + i][x + j] += key[key.length - j - 1][i];
                }
            }
        }
    }

    public boolean check(int[][] newLock, int keyLength, int lockLength) {
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                if(newLock[keyLength + i][keyLength + j] != 1) return false;
            }
        }

        return true;
    }
}
