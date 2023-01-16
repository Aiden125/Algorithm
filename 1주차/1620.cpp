#include <bits/stdc++.h>
using namespace std;
/*
N, k
���ϸ��� �̸���
������ϴ� ���ϸ��� �̸��Ǵ� ��ȣ 
*/

int N, k;
string s; 
map<int, string> mp;
map<string, int> mp2;
bool is_digit(string str) { // atoi�� ���ڸ� ����, ���ڿ��̸� 0�� ��ȯ�Ѵ�. 
	return atoi(str.c_str()) != 0 || str.compare("0") == 0;
}

int main() {
	ios_base::sync_with_stdio(false); // �ð��ʰ� �� �� �ִ� ��� �Է����ֱ� 
	cin.tie(NULL); cout.tie(NULL);
	cin >> N >> k;
	
	for(int i=0; i<N; i++) {
		cin >> s;
		mp[i+1] = s;
		mp2[s] = i+1;
	}
	
	for(int i=0; i<k; i++) {
		cin >> s;
		if(is_digit(s)) {
			cout << mp[atoi(s.c_str())] << "\n";
		}else {
			cout << mp2[s] << "\n";
		}
	}
	
	return 0;
}

