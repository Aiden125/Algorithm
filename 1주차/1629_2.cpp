#include <bits/stdc++.h>
using namespace std;
/*
a�� b�� ���Ѽ��� c�� ���� ��������
10 4 -> 10 10 10 10
10 1 2 4
*/
typedef long long ll;
ll a,b,c;
ll result;
ll fun(ll a, ll b) {
	
	if(b==1) return a%c; // ���� 
	
	result = fun(a, b/2);
	result = (result * result)%c;
	
	if(b%2) result = (result * a)%c; // Ȧ�� ������ ��� 
	return result;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> a >> b >> c;
	cout << fun(a,b);
	return 0;
}
