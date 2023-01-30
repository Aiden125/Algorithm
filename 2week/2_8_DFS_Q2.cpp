#include <bits/stdc++.h>
using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int m, n, k, y, x, ret, ny, nx, t;
int a[104][104];
bool visited[104][104];

void dfs(int y, int x) {
	visited[y][x] = 1;
	cout <<  y << " : " << x << '\n';
	for(int i=0; i<4; i++) { // 4방향 탐색 
		ny = y+dy[i];
		nx = x+dx[i];
		if(ny < 0 || nx<0 || ny>=n || nx>=m) continue;
		if(a[ny][nx] == 1 && !visited[ny][nx]){
			dfs(ny, nx);
		}
	}
	return;
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int i=0; i<n; i++) { // 맵 입력받기 
		for(int j=0; j<n; j++){
			cin >> a[i][j];
		}
	}
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(a[i][j] == 1 && !visited[i][j]){ // 방문안했다면 
				cout << i << " : " << j << " dfs가 시작됩니다.\n";
				dfs(i, j);
				ret++;
			}
		}
	}
	cout << ret << "\n";
	return 0;
	
/*
입력 
5 5
1 0 1 0 1
1 1 0 0 1
0 0 0 1 1
0 0 0 1 1
0 1 0 0 0

출력
4 
*/
