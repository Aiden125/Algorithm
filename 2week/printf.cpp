/*
1. dy, dx 선언, visited 배열선언n*m보다 많게 
2. 다입력받기 n, m, n~m 맵
3. q생성, visited = 1처리, push
4. while문 돌리기 
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
 			a[i][j] = s[j] - '0';
		 }
	}
	cout << "\n";
	
	
	 
	for(int i=0; i<n; i++){
 		for(int j=0; j<m; j++){
 			cout << (int)a[i][j];
		}
		cout << "\n";
	}
	
 	return 0;
 }
