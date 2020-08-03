#include <iostream>
#include <vector>
using namespace std;

int main(void){

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int testCase;

    cin >> testCase;

    for(int i = 0; i < testCase; i++) {
        int A, B, N;
        cin >> A;
        cin >> B;
        cin >> N;

        cout << A << " " << B << " " << N << "\n";
    }

}