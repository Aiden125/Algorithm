#include <bits/stdc++.h>
using namespace std;

const int n=3; // 배열의 크기에 맞춰 지정하면됨
int a[n][n], visited[n][n];
const int dy[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};

void go(int y, int x) {
	visited[y][x] = 1;
	cout << y << " : " << x << "\n";
	for(int i=0; i<4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		
		if(ny <0 || ny >=n || nx <0 || nx>=n) continue; // 꼭 맨 먼저 선언 overflow, underflow 방지   
		if(a[ny][nx] == 0) continue; // 갈수없는 지역 
		if(visited[ny][nx]) continue; // 방문한 정점 
		go(ny, nx);
	}
	return;
}
int main() {
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			cin >> a[i][j];
		}
	}
	go(0, 0);
}

