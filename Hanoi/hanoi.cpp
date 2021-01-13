#include <iostream>
using namespace std;

void hanoi(int n, int a, int b, int c){

    if(n == 1){
        cout << a << " " << c << '\n';
        return;
    }

    hanoi(n-1, a, c, b);

    cout << a << " " << c << '\n';

    hanoi(n-1, b, a, c);


}

int main(void) {
    
    int n;
    cin >> n;
    cout << (1<<n)-1 << '\n';
    if(n <= 20) {
        hanoi(n, 1, 2, 3);
    }else if(n > 100){
        return 0;
    }
}

/*
수가 작을 때는 잘 작동하지만 
n이 96일 때 횟수가 이상하게 나옴
뭐가 문젤까 
*/