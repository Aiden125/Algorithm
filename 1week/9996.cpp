/*
https://www.acmicpc.net/problem/9996

substr Ȱ�� 
*/
#include <bits/stdc++.h>
using namespace std;

int n;
string s, pattern, prefix, sufix; // prefix == ���λ�, sufix == ���̻� 

int main() {
	cin >> n;
	cin >> pattern;
	int pos = pattern.find('*');
	prefix = pattern.substr(0, pos); // ���λ� ���� 
	sufix = pattern.substr(pos+1); // ���̻� ���� 
	
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
