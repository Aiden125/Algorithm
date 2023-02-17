#include <bits/stdc++.h>
using namespace std;

int n;
int a;
stack<int> st; // 폭탄
vector<pair<int, int>> v[1000004];

int main(){

    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> a;

        if(st.empty()){
            st.push(a);
        }else{
            if(st.top() >= a) {
                st.push(a);
            }else{
                while(st.top() < a){
                    st.pop();
                }
            }
        }
    }

    return 0;
}
// 1. stack 빈 경우 그냥 push
// 2. stack