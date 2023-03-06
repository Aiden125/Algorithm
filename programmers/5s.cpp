#include <bits/stdc++.h>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    
    int numSize = number.size() - k;
    int start = 0;
    
    // 1924, k=2
    // 슬라이딩 윈도우 같은 느낌의 풀이
    for(int i=0; i<numSize; i++) {
        char maxNum = number[start]; // 9
        int maxIdx = start; // 3

        // j=3; j<=3; j++
        // j가 어떻게 k+i가 나오는지가 중요할 듯
        for(int j=start; j<=k+i; j++){
            if(maxNum < number[j]){ // 1 < 9
                maxNum = number[j]; // 9
                maxIdx = j; // 2
            }
        }

        start = maxIdx + 1; // 3
        answer += maxNum; // 9
    }

    return answer;
}