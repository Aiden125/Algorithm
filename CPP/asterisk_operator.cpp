#include <bits/stdc++.h>
using namespace std;

int main() {
	string a = "abcda";
	string * b = &a; // 포인터 정의 
	cout << b << "\n";
	cout << *b << "\n"; // 연산자(*)를 이용해 역참조 
	
	return 0;
}

/*
0x6ffdf0
abcda
*/
