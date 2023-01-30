void inOrder(int here){
	if(visited[here] == 0){
		if(adj[here].size() == 1){
			inOrder(adj[here][0]);
			visited[here] = 1;
			cout << here << ' ';
		}else if(adj[here].size() == 2) {
			inOrder(adj[here][0]);
			
			visited[here] = 1;
			cout << here << ' ';
			
			inOrder(adj[here][1]);
		}else {
			visited[here] = 1;
			cout << here << ' ';
		}
	}
}
