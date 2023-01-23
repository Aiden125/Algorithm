#include <bits/stdc++.h>
using namespace std;

const int V = 10;
bool a[V][V], visited[V];
void go(int from) {
	visited[from] = 1; // 방문한 곳 체크 
	cout << from << '\n'; // 방문한 곳 출력 
	
	for(int i=0; i<V; i++) {
		if(visited[i]) continue; // 이미 방문했으면 넘어가기 
		if(a[from][i]){ // 방문 안했었으면 go에 넣기 
			go(i);
		}
	}
	return;
}

int main() {
	// 인접행렬 간선 연결 
	a[1][2] = 1; a[1][3] = 1; a[3][4] = 1;
	a[2][1] = 1; a[3][1] = 1; a[4][3] = 1;
	
	for(int i=0; i<V; i++) {
		for(int j=0; j<V; j++) {
			if(a[i][j] && visited[i] == 0){ // 연결되어 있고, 방문을 안했으면 go에 넣기 
				go(i);
			}
		}
	}
	return 0;
}
