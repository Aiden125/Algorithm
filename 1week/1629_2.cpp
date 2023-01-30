#include <bits/stdc++.h>
using namespace std;
/*
a를 b번 곱한수를 c로 나눈 나머지값
10 4 -> 10 10 10 10
10 1 2 4
*/
typedef long long ll;
ll a,b,c;
ll result;
ll fun(ll a, ll b) {
	
	if(b==1) return a%c; // 기저 
	
	result = fun(a, b/2);
	result = (result * result)%c;
	
	if(b%2) result = (result * a)%c; // 홀수 연산인 경우 
	return result;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> a >> b >> c;
	cout << fun(a,b);
	return 0;
}
