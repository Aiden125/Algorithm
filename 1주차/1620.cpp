#include <bits/stdc++.h>
using namespace std;
/*
N, k
포켓몬의 이름들
맞춰야하는 포켓몬의 이름또는 번호 
*/

int N, k;
string s; 
map<int, string> mp;
map<string, int> mp2;
bool is_digit(string str) { // atoi는 숫자면 숫자, 문자열이면 0을 반환한다. 
	return atoi(str.c_str()) != 0 || str.compare("0") == 0;
}

int main() {
	ios_base::sync_with_stdio(false); // 시간초과 날 수 있는 경우 입력해주기 
	cin.tie(NULL); cout.tie(NULL);
	cin >> N >> k;
	
	for(int i=0; i<N; i++) {
		cin >> s;
		mp[i+1] = s;
		mp2[s] = i+1;
	}
	
	for(int i=0; i<k; i++) {
		cin >> s;
		if(is_digit(s)) {
			cout << mp[atoi(s.c_str())] << "\n";
		}else {
			cout << mp2[s] << "\n";
		}
	}
	
	return 0;
}

