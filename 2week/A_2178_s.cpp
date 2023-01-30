/*
1. dy, dx 선언, visited 배열선언n*m보다 많게 
2. 다입력받기 n, m, n~m 맵
3. q생성, visited = 1처리, push
4. while문 돌리기 
*/
#include <bits/stdc++.h>
using namespace std;

 const int max_n = 104; // n의 크기 기준으로 max 선언 
 int dy[4] = {-1, 0, 1, 0}; // 네가지 방향 
 int dx[4] = {0, 1, 0, -1}; // 네가지 방향 
 int n, m; // n x m 의 크기 맵 
 int a[max_n][max_n], visited[max_n][max_n]; // a는 map 그 자체, visi는 방문처리 
 int y, x;
 
 int main() {
 	scanf("%d %d", &n, &m); // 입력받기 
 	for(int i=0; i<n; i++){
 		for(int j=0; j<m; j++){ // 하나씩 입력받기 a[i][j]에다가 
 			scanf("%1d", &a[i][j]);
		}
	}
	 
	queue<pair<int, int>> q; // q선언 
	visited[0][0] = 1; // 0,0방문처리 
	q.push({0, 0}); // q에 넣기 
	while(q.size()){ // q가 있다는건 움직일 땅이 있다는 뜻 
		tie(y,x) = q.front(); // q에 가장 먼저 들어간 원소 리턴 
		q.pop(); // 큐에 가장 먼저 들어간 원소 팝 
		cout << " y : " << y << " x : " << x << "\n";
		for(int i=0; i<4; i++){
			int ny = y + dy[i]; // 위로 보기 
			int nx = x + dx[i]; // 옆으로 보기 
			
			if(ny<0 || nx<0 || ny>=n || nx>=m) continue; // over,underflow
			if(a[ny][nx] == 0) continue; // 육지가 아닌경우 
			if(visited[ny][nx]) continue; // 방문한 경우(0이 아닌 경우) 
			visited[ny][nx] = visited[y][x] +1; // 다음땅은 visited에 넣어놓은 뒤 
			q.push({ny, nx}); // q에 푸시 
		}
	}
	printf("%d", visited[n-1][m-1]); // n,x의 인덱스 값으로 조회하기에 -1 넣어주기 
	
 	return 0;
 }
