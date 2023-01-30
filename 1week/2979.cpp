/*
트럭 주차 https://www.acmicpc.net/problem/2979
배열을 만들어서 카운팅
시각은 이상, 미만으로 잡는다 
*/
#include <bits/stdc++.h>
using namespace std;

int A,B,C,a,b,cnt[104],ret;
int main() {
	cin >> A >> B >> C;
	for(int i=0; i<3; i++) {
		cin >> a >> b; // 도착시간, 떠나시간 
		for(int j=a; j<b; j++) { // 시각관련이라 이상, 미만으로 잡아준다 
			cnt[j]++; // 1, 6을 받았다 할 경우 cnt = 0 1 1 1 1 1 0 0 0  
		}
	}
	
	for(int j=1; j<100; j++) { 
		if(cnt[j]) {
			if (cnt[j] == 1) {
				ret += A;
			} else if (cnt[j] == 2) {
				ret += B * 2;
			} else if (cnt[j] == 3) {
				ret += C * 3;
			}
		}
	}
	
	cout << ret << '\n';
	
	
	return 0;
}
