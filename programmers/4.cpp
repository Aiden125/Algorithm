// 올바른 괄호 https://school.programmers.co.kr/learn/courses/30/lessons/12909
#include <bits/stdc++.h>
using namespace std;
string s;

bool solution(string s){
    bool answer = true;

    stack<char> st;
    for(char a : s){
        cout << a;
        if(a == '('){
            st.push(a);
        }else{
            if(st.size() && st.top()=='('){
                st.pop();
            }else{
                return false;
            }
        }
    }
    if(st.size()){
        return false;
    }


    return answer;
}

/** main은 테스트용 */
int main() {
    cin >> s;
    bool ans = solution(s);

    if(ans){
        cout << "true";
    }else{
        cout << "false";
    }

    return 0;
}