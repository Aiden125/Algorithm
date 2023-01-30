#include <bits/stdc++.h>
using namespace std;

int main() {
	string a = "나는야";
	cout << a[0] << a[1] << a[2] << "\n";
	cout << a[0] << "\n"; // ⓐ 
	cout << a << "\n";
	
	string b = "abc";
	cout << b[0] << "\n";
	cout << b << "\n";
	return 0;
}

/*
영어는 1바이트, 한글은 3바이트이기 때문에
a 포인트에서 출력이 제대로 되지 않는 현상이 생긴다. 
*/
