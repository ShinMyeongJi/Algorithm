# Betrand

* 수정 전

```
  while(true){
    int n;
    
    vector<int> primes;
    
    cin >> n;
    
    if(n == 0) break;
    
    for(int i = n+1; i < 2*n; i++){
      int number = 0;
      
      for(int j =1; j <= i; j++){
        if(i%j==0) number++;
      }
    }
    if(number ==2) primes.push_back(i);
  }
  
  cout << primes.size() << endl;
```


기존의 소수 구하기 알고리즘으로 풀면 시간초과 에러가 난다. (시간복잡도 O(N²))


# 에라토스테네스의 체

에라토스테네스의 체는 가장 유명한 소수 찾기 테크닉 중 하나로, 1~N 범위 내의 모든 소수를 찾을 때, 2부터 시작해 차례차례 나타나는 수들의 배수를 모두 소수가 아닌 수로 제외시키며 소수인지 여부를 미리 저장해두는 알고리즘이다.

![Image of Yaktocat](https://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif)


현 방법과 같이 풀면 시간복잡도 O(Nlg(lgN))
