#include <bits/stdc++.h>
using namespace std;

int main() {
	double ret = 2.12323;
	int n= 2;
	int a = (int) round(ret / double(n));
	cout << a << "\n";
	
	return 0;
}

/**
연산할 때 팁 = 같은 타입끼리 연산하는 것
ex) double/double, int/int 

만약 다르게 나눈다면 이를 찾기는 쉽지않다. 
*/
