/*
https://www.acmicpc.net/problem/1159
1. 첫글자만 따서 배열에 증가(26개짜리 배열) 
2. 5이상인 알파벳 출력(사전순으로)
3. 아닐경우 PREDAJA 출력 
*/
#include <bits/stdc++.h>
using namespace std;

int N;
int arr[26];
string a;
string first;
bool sw = false;
int main() {
	
	cin >> N;
	
	for(int i=0; i<N; i++) {
		cin >> a;
		
		arr[a[0] - 97]++;
	}
	
	for(int i=0; i<26; i++) {
		if(arr[i] >= 5) {
			cout << (char) (i + 'a') << "";
			sw = true;
		}
	}
	
	if(!sw) {
		cout << "PREDAJA" << '\n';
	}
	
	return 0;
}
