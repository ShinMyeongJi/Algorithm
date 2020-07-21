#include <iostream>
#include <queue>
#include <vector>
using namespace std;
#define MAX 123456
/**
 * BOJ 4948 (시간복잡도 : N²)
 */
int main(void){
    while(true) {
        int n;
        int cnt = 0;
        cin >> n;

        if(n == 0) break;
        
        bool notPrimes[2*n] = {};

        notPrimes[0] = true;
        notPrimes[1] = true;
        
        for(int i = 2; i <= 2*n; i++){
            if(notPrimes[i]) continue;
            for(int j = i*2; j < 2*n; j+=i){
                notPrimes[j] = true;
            }
        }
    
        if(n != 1) {
            for(int i = n+1; i < 2*n; i++){
                cnt += !notPrimes[i] ? 1 : 0;
            }
        }else{
            for(int i = n+1; i <= 2*n; i++){
                cnt += !notPrimes[i] ? 1 : 0;
            }
        }
        

        cout << cnt << endl;
        
    }
}

