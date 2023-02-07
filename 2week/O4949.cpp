#include <bits/stdc++.h>
using namespace std;

int main(){
    while(true){
        string s;
        getline(cin, s);
        if(s==".") break;

        stack<char> st;
        bool sw = true;
        for(char it : s) {
            if(it == '(' || it == '[') {
                st.push(it);
            }else if(it == ')'){
                if(!st.empty() && st.top()=='('){
                    st.pop();
                }else{
                    sw = false;
                    break;
                }
            }else if(it == ']'){
                if(!st.empty() && st.top()=='['){
                    st.pop();
                }else{
                    sw = false;
                    break;
                }
            }
        }

        if(sw && st.empty()){
            cout << "yes" << "\n";
        }else{
            cout << "no" << "\n";
        }



    }
    return 0;
}