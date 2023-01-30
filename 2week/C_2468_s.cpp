 #include <bits/stdc++.h>
using namespace std;

int mapa[101][101], visited[101][101], n, temp;
int result = 1;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void dfs(int y, int x, int depth) {
	visited[y][x] = 1;
	for(int i=0; i<4; i++){
		int ny = y+dy[i];
		int nx = x+dx[i];
		
		if(ny<0 || nx<0 || y>n || x>n) continue;
		if(!visited[ny][nx] && mapa[ny][nx] > depth) dfs(ny, nx, depth);
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			cin >> mapa[i][j];
		}
	}
	
	for(int depth=1; depth<101; depth++){
		fill(&visited[0][0], &visited[0][0] + 101*101, 0); // 무슨 초기화인지 
		int cnt = 0;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(mapa[i][j] > depth && !visited[i][j]) {
					dfs(i, j, depth);
					cnt++;
				}
			}
		}
		result = max(result, cnt);
	}
	cout << result << '\n';
	return 0;
}
