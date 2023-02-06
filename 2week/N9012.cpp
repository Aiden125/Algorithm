#include <bits/stdc++.h>
using namespace std;

int n;
string s;
int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s;
        stack<char> st;
        bool sw = true;

        for(char it : s){ // 하나의 문자열
            if(it == '(') st.push(it);
            if(it == ')') {
                if(!st.empty() && st.top() == '('){
                    st.pop();
                }else{
                    sw = false;
                    break;
                }
            }
        }

        if(sw && st.empty()){
            cout << "YES" << "\n";
        }else {
            cout << "NO" << "\n";
        }

    }
    return 0;
}