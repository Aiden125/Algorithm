#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll a,b,c;
ll result;
ll make_result(ll a, ll b){
	// ������� 
	if(b == 1) return a%c; // �׳� 10 1�� ���Դٰ� �����ϸ� �� return ��������� ���ø��� �ȴ�. 
	
	result = make_result(a, b/2);
	result = (result * result) %c; // ���� ��ȿ ���� 
	
	if(b % 2) { // b�� Ȧ���� ��� 
		result = (result * a) %c;
	}
	return result; 
}

int main() {
	cin >> a >> b >> c;
	cout << make_result(a, b) << "\n";
	
	
	return 0;
}
