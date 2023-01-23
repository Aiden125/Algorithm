#include <bits/stdc++.h>
using namespace std;

const int n = 6;
vector<int> adj[n];
int visited[n];
void dfs(int u){ // adj를 전역변수로 선언했기에 매개변수로 받을 필요가 없다
	visited[u] = 1;
	cout << u << "\n";
	for(int v : adj[u]) { // 리프노드가 없다면 이 함수가 발동x 
		if(visited[v] == 0){
			dfs(v);
		}
	}
	cout << u << "로부터 시작된 함수가 종료되었습니다.\n";
	return;
}

int main() {
	adj[1].push_back(2);
	adj[1].push_back(3);
	adj[2].push_back(4);
	adj[4].push_back(2);
	adj[2].push_back(5);
	dfs(1);
	
	return 0; 
}
