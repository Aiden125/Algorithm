#include <bits/stdc++.h>
using namespace std;

/*
2차원 배열 vector 
*/
vector<vector<int>> v;
vector<vector<int>> v2(10, vector<int>(10, 0));
vector<int> v3[10];

int main() {
	for(vector<int> v : v2) {
		for(int i : v) {
			cout << i << ' ';
		}
		cout << '\n';
	}
	
	for(int i = 0; i < 10; i++) {
		vector<int> vv;
		v.push_back(vv);
	}
	return 0;
}
