#include <bits/stdc++.h>
using namespace std;

const int max_n = 104;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int n, m, a[max_n][max_n], visited[max_n][max_n], y,x,sy,sx,ey,ex;

int main() {
	cin >> n >> m;
	cin >> sy >> sx;
	cin >> ey >> ex;
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++){
			cin >> a[i][j];
		}
	}
	
	queue<pair<int, int>> q;
	visited[sy][sx] = 1; // 이걸 꼭 거는걸 추천 
	q.push({sy, sx});
	while(q.size()) {
		tie(y,x) = q.front(); q.pop();
		for(int i=0; i<4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
			if(visited[ny][nx]) continue;
			visited[ny][nx] = visited[y][x] + 1;
			q.push({ny, nx});
		}
	}
	printf("%d\n", visited[ey][ex]);
	
	// 최단거리 디버깅
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			cout << visited[i][j] << ' ';
		}
		cout << '\n';
	} 
	return 0;
}
/*
5 5
0 0
4 4
1 0 1 0 1
1 1 1 0 1
0 0 1 1 1
0 0 1 1 1
0 0 1 1 1
*/
