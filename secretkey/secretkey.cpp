#include <iostream>
#include <vector>
using namespace std;
#define MAX 1000001

int main(void){
    bool all[MAX];
    vector<int> prime;

    all[0] = false;
    all[1] = false;

    for(int i = 2; i < MAX; i++){
        all[i] = true;
    }

    for(int i = 2; i*i < MAX; i++){
        if(!all[i]) continue;
        for(int j = i*i; j < MAX; j+=i){
            all[j] = false;
        }  
    }


    for(int i = 2; i < MAX; i++) {
        if(all[i]) prime.push_back(i);
    }

    int n;
    cin >> n;
    bool flag = true;
    
    for(int i = 0; i < n; i++){
        long long S;
        cin >> S;
        
        for(int j = 0; j < prime.size(); j++){

                if(S%prime[j] == 0) {
                    flag = false;
                    cout << "NO" << endl;
                    break;

            }
        }
      
        if(flag){
            cout << "YES" << endl;
        }
        flag = false;     
    }
}
