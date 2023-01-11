/*
https://www.acmicpc.net/problem/9996

substr 활용 
*/
#include <bits/stdc++.h>
using namespace std;

int n;
string s, pattern, prefix, sufix; // prefix == 접두사, sufix == 접미사 

int main() {
	cin >> n;
	cin >> pattern;
	int pos = pattern.find('*');
	prefix = pattern.substr(0, pos); // 접두사 패턴 
	sufix = pattern.substr(pos+1); // 접미사 패턴 
	
	for(int i=0; i<n; i++) {
		cin >> s;
		if(pattern.size()-1 > s.size()) {
			cout << "NE" << "\n";
		}else {
			if(prefix == s.substr(0, prefix.size()) && sufix == s.substr(s.size() - sufix.size())) {
				cout << "DA" << "\n";
			}else {
				cout << "NE" << "\n";
			}
		}
	}
	
	return 0;
}
