#include <bits/stdc++.h>
using namespace std;

int n, a[1000004], ret[1000004];
stack<int> st;
int main() {
    cin >> n;
    
    // 애초에 -1로 초기화 해버림
    memset(ret, -1, sizeof(ret));

    // a를 배열로 선언해서 쉽게
    for(int i=0; i<n; i++) {
        cin >> a[i];

        // st.top()이 어떻게 인덱스로 쓰이지?
        while(st.size() && a[st.top()] < a[i]){
            ret[st.top()] = a[i];
            st.pop();
        }
        
        // 스택에 값이 아닌 애초에 인덱스를 넣음
        st.push(i);
    }

    for(int i=0; i<n; i++) {
        cout << ret[i] << " ";
    }

    return 0;
}