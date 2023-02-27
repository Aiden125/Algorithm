// 전화번호 목록 https://school.programmers.co.kr/learn/courses/30/lessons/42577
#include <bits/stdc++.h>
using namespace std;

bool solution(vector<string> phone_book){
    bool answer = true;
    sort(phone_book.begin(), phone_book.end());
    for(int i=0; i<phone_book.size()-1; i++){
        int aa = phone_book[i+1].size();
        int a = phone_book[i].size();
        if(aa > a){
            if(phone_book[i+1].substr(0, a) == phone_book[i]){
                return false;
            }
        }
    }

    return answer;
}


int main() {
    
    return 0;
}