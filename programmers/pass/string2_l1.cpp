/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * 완주하지 못한 선수
*/
#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> st, vector<string> en) { // 도전, 완주
    string answer = "";
    
    map<string, int> mp;
    for(int i=0; i<st.size(); i++){
        mp[st[i]]++;
    }
    for(int i=0; i<en.size(); i++){
        mp[en[i]]--;
    }
    for(auto it : mp){
        if(it.second){
            answer = (it).first;
        }
    }
    return answer;
}