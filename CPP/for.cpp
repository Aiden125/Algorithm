#include <bits/stdc++.h>
using namespace std;

string a[2] = {"out of time", "I love you"};
int main() {
	for(string b : a) {
		cout << b << "\n";
	}
	
	for(int i = 0; i < 2; i++) {
		cout << a[i] << "\n";
	}
}
/*
out of time
I love you
out of time
I love you

다른언어처럼 for문 사용가능 C++11부터 
*/
