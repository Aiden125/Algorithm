#include <bits/stdc++.h>
using namespace std;

double a(); // 선언부 

int main() {
	double ret = a();
	cout << ret << "\n";
	return 0;
}

double a() { // 정의부 
	return 1.2333;
}

/*
알고리즘은 시간싸움이기에 선언부, 정의부를
깔끔하게 나눠서 할 필요없이 한꺼번에 정의하는게 낫다.
시간위주로 뭐가 더 빠른지에 따라 결정할 것 
*/
