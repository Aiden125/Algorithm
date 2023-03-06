// https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java
#include <bits/stdc++.h>
using namespace std;
/**
1. k만큼 자르기 전에 가장 큰 수를 일단 찾아야한다.
2. k 만큼 실제로 잘라주고 그래도 k가 남으면 더 자를것들을 안에서 찾는다.
*/

string solution(string number, int k) {
    string answer = "";
    int numberSize = number.length();
    bool numbers[numberSize];
    memset(numbers, 1, sizeof(numbers));

    int max = 0;
    int index = 0;
    int standardK = numberSize - k;
    for(int i=0; i<standardK; i++){
        if(max<number[i]){
            max = number[i];
            index = i;
        }
    }
    
    for(int i=0; i<index; i++){
        numbers[i] = 0;
    }

    int decayK = k - index;
    int minusNum = 0;
    for(int i=index; i<numberSize; i++){
        if(number[i] < number[i+1]) {
            numbers[i] = 0;
            decayK -= 1;
        }
        if(decayK <= 0) break;
    }

    while(decayK >= 0) {
        numbers[numberSize - decayK] = false;
        decayK--;
    }

    for(int i=0; i<numberSize; i++) {
        if(numbers[i]){
            answer += number[i];
        }
    }

    return answer;
}

int main() {
    string number;
    int k;
    
    // test1
    number = "1924";
    k = 2;
    cout << solution(number, k) << "\n";

    // test2
    number = "1231234";
    k = 3;
    cout << solution(number, k) << "\n";

    // test3
    number = "4177252841";
    k = 4;
    cout << solution(number, k) << "\n";

    return 0;
}



