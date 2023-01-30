/*
팰림드롬인지 확인하기 https://www.acmicpc.net/problem/10988

reverse() ?
*/
#include <bits/stdc++.h>
using namespace std;

string a;
int main() {
	
	cin >> a;
	
	string b = a;
	
	reverse(b.begin(), b.end());
	
	if(a == b) {
		cout << 1 << '\n';
	}else {
		cout << 0 << '\n';
	}
}
