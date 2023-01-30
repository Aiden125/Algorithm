#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
ll a, b, c;

ll go(ll a, ll b) {
	if(b == 1) return a % c; // ±âÀú »ç·Ê
	
	ll ret = go(a, b/2);
	ret = (ret * ret) % c;
	
	if(b % 2) ret = (ret * a) %c;
	return ret;

}
// go(10, 4) -> ret = go(10,2) --> ret= (10,2)

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> a >> b >> c;

	cout << go(a, b) << "\n";
	
	return 0;
}
