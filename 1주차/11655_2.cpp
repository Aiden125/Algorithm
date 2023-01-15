#include <bits/stdc++.h>
using namespace std;
// A = 65 , Z = 90, a = 97 , z = 122

string s; // 주어지는 문자열
string rot13;
int bigA = 'A', bigZ = 'Z', smallA = 'a', smallZ = 'z';
int main() {
	getline(cin, s);
	
	for(int i=0; i<s.length(); i++) {
		int a = s[i];
		
		if(a >= bigA && a <= bigZ) { // 대문자인 경우 
			a += 13;
			if(a > bigZ) {
				a -= 26;
			}
						
		}else if(a>=smallA && a<=smallZ) { // 소문자인 경우 
			a += 13;
			if(a > smallZ) {
				a -= 26;
			}
		}
		cout << (char)a;
		
	}
	
	return 0;
} 

/*
char a 형식으로 지정한 경우
숫자가 아스키코드 값을 넘어가게 되면 깨지는 현상이 발생한다.
 
*/
