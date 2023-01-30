#include <bits/stdc++.h>
using namespace std;
// https://www.acmicpc.net/problem/11655
// A = 65 , Z = 90, a = 97 , z = 122

string s; // �־����� ���ڿ�
string rot13;
int bigA = 'A', bigZ = 'Z', smallA = 'a', smallZ = 'z';
int main() {
	getline(cin, s);
	
	for(int i=0; i<s.length(); i++) {
		char a = s[i];
		
		if(a >= bigA && a <= bigZ) { // �빮���� ��� 
			if(a+13 > bigZ) {
				a = a-26+13;
			}else {
				a += 13;
			}
			
		}else if(a>=smallA && a<=smallZ) { // �ҹ����� ��� 
			if(a+13 > smallZ) {
				a = a -26 + 13;
			}else {
				a = a+13;
			}
		}
		cout << a;
		
	}
	
	return 0;
} 
