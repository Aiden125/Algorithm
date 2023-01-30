#include <bits/stdc++.h>
using namespace std;

int main() {
	string a = "It's hard to have a sore leg";
	reverse(a.begin(), a.end()); // "It's hard to have a sore leg"
	cout << a << '\n';
	reverse(a.begin(), a.end()); // "gel eros a evah drah s'tI"
	cout << a << '\n';
	reverse(a.begin() + 3, a.end());
	cout << a << '\n';
	
	return 0;
}

/*
처음부터 끝까지 뒤집기도 가능하며
원하는 위치 지정해서 뒤집기도 가능 
*/
