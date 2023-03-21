/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 위장
*/

#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    map<string, int> mp;
    
    for(int i=0; i<clothes.size(); i++){
        mp[clothes[i][1]]++; // 없으면 1, 있으면 ++
    }
    int mul = 1;
    for(auto it : mp){
        mul *= (it.second+1);
    }
    answer = mul-1; // 아무것도 안입는 경우 제외
    return answer;
}