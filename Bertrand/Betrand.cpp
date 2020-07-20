#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(void){
    while(true) {
        int n;
 
        vector<int> primes;

        cin >> n;

        if(n == 0) break;

        for(int i = n+1; i < 2*n; i++){
            int number = 0;
            for(int j = 1; j <= i; j++){   
                if(i%j==0){
                    number++;
                }
            }
            if(number == 2) primes.push_back(i);
        }

        cout << primes.size() << endl;
        
    }
}