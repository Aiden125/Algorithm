#include <bits/stdc++.h>
using namespace std;

int n, cnt;
int main() {
	cin >> n;
	
	for(int i=0; i<n; i++){
		string s;
		cin >> s;
		
		stack<char> st;
		for(char a : s){
			if(!st.empty() && st.top() == a) {
				st.pop();
			}else {
				st.push(a);
			}
		}
		
		if(st.empty()) cnt++;
	}
	cout << cnt;
	return 0;
}
