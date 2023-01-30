#include <bits/stdc++.h>
using namespace std;
int T;
string s;
int main() {
	cin >> T;
	string bufferflush;
	getline(cin, bufferflush);
	
	for(int i=0; i < T; i++) {
		getline(cin, s);
		cout << s << "\n";
	}
	
	return 0;
}

/*
개행줄을 여러번 받아야 할 때

입력
2
오늘도 코딩
내일도 코딩

출력
오늘도 코딩
내일도 코딩 
*/
