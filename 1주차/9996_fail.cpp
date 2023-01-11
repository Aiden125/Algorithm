/*
문자를 입력받아서 *앞에 문자가 일치하는지 체크, 뒤에 문자가 일치하는지 체크 
*/
#include <bits/stdc++.h>
using namespace std;

int N;
string a;
string b; //입력 받을 문자열들
bool sw1 = true;
bool sw2 = true;
bool sw3 = true;
int main() {
	
	cin >> N >> a;
	int z = a.find("*");
	cout << "z : " + z << "\n";
	string firstString = a.substr(0, z);
	string lastString = a.substr(z+1);
	for(int i=0; i<N; i++) {
		cin >> b;
		
		for(int j=0; j<firstString.length(); j++) {
			if(firstString[j] != b[j]) {
				cout << "NE" << "\n";
				sw1 = false;
				break;
			}
		}
		
		int AA = lastString.length()-1;
		int BB = b.length()-1;
		
		while(sw3) {
			if(!sw1) break;
			
			if(lastString[AA] != b[BB]) {
				cout << "NE" << "\n";
				break;
			}
			
			AA--;BB--;
			if(z==AA) {
				cout << "DA" << "\n";
				break;
			}
		}
		
	}
}

