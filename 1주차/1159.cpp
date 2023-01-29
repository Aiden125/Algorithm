/*
https://www.acmicpc.net/problem/1159
1. ù���ڸ� ���� �迭�� ����(26��¥�� �迭) 
2. 5�̻��� ���ĺ� ���(����������)
3. �ƴҰ�� PREDAJA ��� 
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
