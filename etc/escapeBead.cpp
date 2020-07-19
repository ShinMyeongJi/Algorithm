/*
13460 구슬 탈출 2
21:17 시작
21:46
29분컷
설계 과정
1. 문제를 정확하게 읽습니다.
2. 설계를 완벽하게 합니다. (예제 3개 돌리기)
3. 경우의 수를 나열합니다.
4. 초기화 관련 변수를 확인합니다.
5. 가지치기를 합니다.
5. 예제와 동일한 변수 선언 및 사용합니다.
풀이 과정
1. bfs 를 사용하여, 빨간 구슬과 파란 구슬의 위치를 저장합니다.
2. 이중 와일문을 사용하여, 덩어리째 처리합니다.
3. 세세한 조건을 정확하게 입력합니다.
*/
 
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
#define SIZE 12
int N, M; // 배열 크기
char map[SIZE][SIZE];
struct point {
    int rx, ry, bx, by;
};
queue<point> que;
int cnt;
int rx, ry, bx, by;
int nrx, nry, nbx, nby;
int orx, ory, obx, oby;
int ans;
int dx[] = { 0,0,1,-1 };
int dy[] = { 1,-1,0,0 };
int visit[SIZE][SIZE][SIZE][SIZE];
 
void problemIn() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> map[i]; //게임판 
        for (int j = 0; j < M; j++) {
            if (map[i][j] == 'R') {
                rx = i; //백업
                ry = j;
                map[i][j] = '.'; //이동가능한 곳으로 일단 찍어둔다
                cout << "RED point : rx, ry = " << rx << ", " << ry << endl;
            }
            else if (map[i][j] == 'B') {
                bx = i;
                by = j;
                map[i][j] = '.';//이동가능한 곳으로 일단 찍어둔다
                cout << "BLUE point : bx, by = " << bx << ", " << by << endl;
            }
        }
    }
}
 
void init() {
 
}
 
void bfs() {
 
    while (!que.empty()) {
        int qlen = que.size();
        while (qlen--) {
            
            orx = que.front().rx;
            ory = que.front().ry;
            obx = que.front().bx;
            oby = que.front().by;
            cout << "orx, ory, obx, oby = " << orx << ", " << ory << ", " << obx << ", " << oby << endl;
            que.pop();
 
            if (map[orx][ory] == 'O' && map[obx][oby] != 'O') {
                ans = cnt;
                return;
            }
 
            for (int i = 0; i < 4; i++) {
                rx = orx;
                ry = ory;
                bx = obx;
                by = oby;

                //빨간구슬 이동
                while (1) {
                    nrx = rx + dx[i];
                    nry = ry + dy[i];
                    cout << "nrx, nry's point : " << nrx << ", " << nry << endl;
                    if (map[nrx][nry] == '#' || map[rx][ry] == 'O') break;
                    rx = nrx;
                    ry = nry;
                }
 
                //파란구슬 이동
                while (1) {
                    nbx = bx + dx[i];
                    nby = by + dy[i];
                    cout << "nbx, nby's point' : " << nbx << ", " << nby << endl;
                    if (map[nbx][nby] == '#' || map[bx][by] == 'O') break;
                    bx = nbx;
                    by = nby;
                }
 
                if (rx == bx && ry == by) {
                    if (map[bx][by] == 'O') continue;
                    if (abs(orx - rx) + abs(ory - ry) > abs(obx - bx) + abs(oby - by)) { //절댓값 반환함수 abs // 기존 queue에 담겨있던 R,B 의 좌표
                        cout << "abs(orx - rx) + abs(ory - ry) = " << abs(orx - rx) + abs(ory - ry) <<endl;
                        cout << "abs(obx - bx) + abs(oby - by) = " << abs(obx - bx) + abs(oby - by) <<endl;
                        rx -= dx[i];
                        ry -= dy[i];
                        cout << "rx -= dx[i] = " << rx << endl;
                        cout << "ry -= dy[i] = " << ry << endl;
                    }
                    else {
                        cout << "abs(orx - rx) + abs(ory - ry) = " << abs(orx - rx) + abs(ory - ry) <<endl;
                        cout << "abs(obx - bx) + abs(oby - by) = " << abs(obx - bx) + abs(oby - by) <<endl;
                        bx -= dx[i];
                        by -= dy[i];
                        cout << "bx -= dx[i] = " << bx << endl;
                        cout << "by -= dy[i] = " << by << endl;
                    }
                }
 
                if (visit[rx][ry][bx][by]) continue;
                visit[rx][ry][bx][by] = 1;
                que.push({ rx,ry,bx,by });
            }
        }
        if (cnt == 10) {
            ans = -1;
            return;
        }
        cnt++;
    }
 
    ans = -1; // 큐가 먼저 끝나는 경우.
    return;
}
 
void solve() {
 
    visit[rx][ry][bx][by] = 1;
    que.push({ rx,ry,bx,by });
    bfs();
 
}
 
int main() {
    problemIn();
    solve();
    cout << ans << endl;
}