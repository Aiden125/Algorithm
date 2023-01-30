#include <bits/stdc++.h>
using namespace std;

int main() {
	vector<pair<int, int>> v;
	for(int i = 1; i <= 5; i++) {
		v.push_back({i, i});
	}
	
	for(auto it : v) {
		cout << it.first << " : " << it.second << "\n";
	}
	
	for(pair<int, int> it : v) {
		cout << it.first << " : " << it.second << "\n";
	}
	
	return 0;
}

/**
pair<int, int> 처럼 길게 안쓰고 auto를 활용할 수 있다. 
*/
