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
