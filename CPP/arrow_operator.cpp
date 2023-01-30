#include <bits/stdc++.h>
using namespace std;

pair<int, int> a = {1, 2};
int main() {
	pair<int, int> * b = &a;
	cout << b << "\n";
	cout << b -> first << "\n";
	cout << (*b).first << "\n";
	
	return 0;
}

/*
0x472010
1
1
*/
