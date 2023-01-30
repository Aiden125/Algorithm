#include <bits/stdc++.h>
using namespace std;

double a = 1.23456789;

int main() {
	cout << a << "\n"; // 1.23457
	cout.precision(7); // 소수7번째에서 반올림하라 
	cout << a << "\n"; // 1.234568
	return 0;
}
