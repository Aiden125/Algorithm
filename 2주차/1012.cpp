#include <bits/stdc++.h>
using namespace std;

int t, n, m, k;
const int max_n = 54;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int a[max_n][max_n];
bool visited[max_n][max_n];
int x, y, ret;

void dfs(int y, int x){
	visited[y][x] = 1;
		for(int j=0; j<4; j++){
			int ny = y + dy[j];
			int nx = x + dx[j];
			
			if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
			if(a[ny][nx] == 1 && !visited[ny][nx]){
				dfs(ny, nx);
			}
		}
}
int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> t;
	
	for(int i=0; i<t; i++){
		cin >> n >> m >> k;
		
		for(int j=0; j<k; j++){
			cin >> x >> y;
			a[y][x] = 1;
		}
		cout << '\n';
		
		for(int j=0; j<n; j++){
			for(int u=0; u<m; u++){
				if(a[j][u] == 1 && !visited[j][u]){
//					cout << i << " : " << j << " dfs가 시작됩니다.";

					dfs(j, u);
					ret++;
				}
			}
		}
		
		cout << ret << "\n";
		
		
	}
	
	return 0;
}
