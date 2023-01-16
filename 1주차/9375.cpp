#include <bits/stdc++.h>
using namespace std;
/*
n 의상의 수, 의상 갯수 k 
의상 이름, 부위들 
*/

int N, k;
string a, b;
int main() {
	
	cin >> N;
	
	for(int i=0; i<N; i++){
		map<string, int> mp;
		cin >> k;
		for(int j=0; j<k; j++) {
			cin >> a;
			cin >> b;
			mp[b]++;
		}
		
		long long ret = 1;
		for(auto q : mp) {
			ret *= ((long long)q.second + 1);
		}
		ret--;
		cout << ret << "\n";
	}
	
	
	return 0;
}


