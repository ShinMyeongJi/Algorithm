#include <iostream>
#include <queue>
#include <vector>
using namespace std;
/**
 * BOJ 4948
 */
int main(void){
    while(true){
        int n;
        int cnt = 0;
        cin >> n;

        if(n == 0) break;

        bool notPrimes[2*n] = {};

        notPrimes[0] = notPrimes[1] = true;

        for(int i = 2; i < 2*n; i++){
            if(notPrimes[i]) continue;
            for(int j = i * 2; j < 2*n; j+=i){
                notPrimes[j] = true;
            }
        }


        for(int i = n + 1; i < 2*n; i++){
            if(!notPrimes[i]) cnt++;
        }
        if(n == 1) cnt++;
        cout << cnt << endl;
    }
}

