#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll a,b,c;
ll result;
ll make_result(ll a, ll b){
	// 기저사례 
	if(b == 1) return a%c; // 그냥 10 1이 들어왔다고 생각하면 뭘 return 해줘야할지 떠올리면 된다. 
	
	result = make_result(a, b/2);
	result = (result * result) %c; // 실제 유효 연산 
	
	if(b % 2) { // b가 홀수인 경우 
		result = (result * a) %c;
	}
	return result; 
}

int main() {
	cin >> a >> b >> c;
	cout << make_result(a, b) << "\n";
	
	
	return 0;
}
