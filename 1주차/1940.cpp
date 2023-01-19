#include<bits/stdc++.h>
using namespace std;

int N, M;
int cnt;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> N >> M;
	if(M>200000) {
		cout << 0 << "\n";
		return 0;	
	}
	
	int k[N];
	for(int i=0; i<N; i++) {
		cin >> k[i];
	}
	
	for(int i=0; i<N; i++){
		for(int j=i+1; j<N; j++){
			if(k[i]+k[j]==M) cnt++;
		}
	}
	cout << cnt << "\n";
	
	return 0;
}
