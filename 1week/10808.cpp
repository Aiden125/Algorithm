/*
알파벳 개수 https://www.acmicpc.net/problem/10808
배열 + 아스키 코드 활용 
*/ 
#include <bits/stdc++.h>
using namespace std;
string S;
int cnt[26];

int main() {
	cin >> S;
	
	for(char a : S) {
		cnt[a - 97]++;
	}
	
	for(int i=0; i<26; i++) {
		cout << cnt[i] << " ";
	}
		
	return 0;
}



