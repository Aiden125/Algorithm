#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int n;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	while(scanf("%d", &n) != EOF){
		
		ll num = 1;
		int temp = 1;
		while(true) {
			if(num%n==0){
				cout << temp << "\n";
				break;
			}else{
				num = (num*10)+1;
				num %= n;
				temp++;
			}
		}
	}
	return 0;
}

