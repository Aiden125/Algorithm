/*
1. dy, dx ����, visited �迭����n*m���� ���� 
2. ���Է¹ޱ� n, m, n~m ��
3. q����, visited = 1ó��, push
4. while�� ������ 
*/
#include <bits/stdc++.h>
using namespace std;

 const int max_n = 104;
 int dy[4] = {-1, 0, 1, 0};
 int dx[4] = {0, 1, 0, -1};
 int n, m, a[max_n][max_n], visited[max_n][max_n], y, x;
 
 int main() {
 	cin >> n >> m;
 	
 	for(int i=0; i<n; i++){
 		string s;
		cin >> s;
 		for(int j=0; j<s.length(); j++){
 			a[i][j] = s[j];
		}
	}
	 
	queue<pair<int, int>> q;
	visited[1][1] = 1;
	while(q.size()){
		tie(y,x) = q.front(); q.pop();
		for(int i=0; i<4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
			if(visited[ny][nx]) continue;
			visited[ny][nx] = visited[y][x] +1;
			q.push({ny, nx});
		}
	}
	printf("%d\n", visited[n][m]);
	
 	return 0;
 }
