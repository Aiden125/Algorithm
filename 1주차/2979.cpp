/*
Ʈ�� ���� https://www.acmicpc.net/problem/2979
�迭�� ���� ī����
�ð��� �̻�, �̸����� ��´� 
*/
#include <bits/stdc++.h>
using namespace std;

int A,B,C,a,b,cnt[104],ret;
int main() {
	cin >> A >> B >> C;
	for(int i=0; i<3; i++) {
		cin >> a >> b; // �����ð�, �����ð� 
		for(int j=a; j<b; j++) { // �ð������̶� �̻�, �̸����� ����ش� 
			cnt[j]++; // 1, 6�� �޾Ҵ� �� ��� cnt = 0 1 1 1 1 1 0 0 0  
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
