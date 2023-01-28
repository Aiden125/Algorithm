/*
1. dy, dx ����, visited �迭����n*m���� ���� 
2. ���Է¹ޱ� n, m, n~m ��
3. q����, visited = 1ó��, push
4. while�� ������ 
*/
#include <bits/stdc++.h>
using namespace std;

 const int max_n = 104; // n�� ũ�� �������� max ���� 
 int dy[4] = {-1, 0, 1, 0}; // �װ��� ���� 
 int dx[4] = {0, 1, 0, -1}; // �װ��� ���� 
 int n, m; // n x m �� ũ�� �� 
 int a[max_n][max_n], visited[max_n][max_n]; // a�� map �� ��ü, visi�� �湮ó�� 
 int y, x;
 
 int main() {
 	scanf("%d %d", &n, &m); // �Է¹ޱ� 
 	for(int i=0; i<n; i++){
 		for(int j=0; j<m; j++){ // �ϳ��� �Է¹ޱ� a[i][j]���ٰ� 
 			scanf("%1d", &a[i][j]);
		}
	}
	 
	queue<pair<int, int>> q; // q���� 
	visited[0][0] = 1; // 0,0�湮ó�� 
	q.push({0, 0}); // q�� �ֱ� 
	while(q.size()){ // q�� �ִٴ°� ������ ���� �ִٴ� �� 
		tie(y,x) = q.front(); // q�� ���� ���� �� ���� ���� 
		q.pop(); // ť�� ���� ���� �� ���� �� 
		cout << " y : " << y << " x : " << x << "\n";
		for(int i=0; i<4; i++){
			int ny = y + dy[i]; // ���� ���� 
			int nx = x + dx[i]; // ������ ���� 
			
			if(ny<0 || nx<0 || ny>=n || nx>=m) continue; // over,underflow
			if(a[ny][nx] == 0) continue; // ������ �ƴѰ�� 
			if(visited[ny][nx]) continue; // �湮�� ���(0�� �ƴ� ���) 
			visited[ny][nx] = visited[y][x] +1; // �������� visited�� �־���� �� 
			q.push({ny, nx}); // q�� Ǫ�� 
		}
	}
	printf("%d", visited[n-1][m-1]); // n,x�� �ε��� ������ ��ȸ�ϱ⿡ -1 �־��ֱ� 
	
 	return 0;
 }
