#include <iostream>
#include <vector>
#define MAX 1000000
using namespace std;

bool primeCheck[MAX];
vector<int> primes;

void eratosthenes(){
    
    primeCheck[0] = primeCheck[1] = false;
    for(int i = 2; i < MAX; i++){
        primeCheck[i] = true;
    }
    
    for(int i = 2; i*i < MAX; i++){
        if(!primeCheck[i]) continue;
        for(int j = i*i; j < MAX; j+=i){
            primeCheck[j] = false;
        }
    }

    for(int i = 3; i < MAX; i++){
        if(primeCheck[i])
            primes.push_back(i);
    }
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    eratosthenes();

    while(true){
        int input;
        cin >> input;

        if(input == 0) break;

        for(int i = 0; i < primes.size(); i++){
            if(primeCheck[input - primes[i]]){
                cout << input << " = " << primes[i] << " + " << input - primes[i] << "\n";
                break;
            }
        }
    }
}