/*
숫자가 작아서 9P7로도 풀 수 있지만
현재 문제는 순서 상관이 없어서 9C7이 정석
9C7 = 9C2 
*/
#include <bits/stdc++.h>
using namespace std;

int a[9], sum;
vector<int> v;
pair<int, int> ret;

void solve() { // 두명을 제외 했을 때 100이 되는 경우 구하기 
	for(int i=0; i<9; i++) {
		for(int j=0; j<i; j++) {
			if(sum - a[i] - a[j] == 100) {
				ret = {i, j};
				return;
			}
		}
	}
}

int main() {
	for(int i=0; i<9; i++) {
		cin >> a[i];
		sum += a[i];
	}
	solve();
	
	for(int i=0; i<9; i++) {
		if(ret.first == i || ret.second == i) continue;
		v.push_back(a[i]);
	}
	sort(v.begin(), v.end());
	
	for(int i : v) {
		cout << i << "\n";
	}
	
	return 0;
}


