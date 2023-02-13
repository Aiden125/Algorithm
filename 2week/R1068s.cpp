#include <bits/stdc++.h>
using namespace std;

/**
 * 1. 연결(n-1)
 * 2. dfs 돌기
*/
int nodeValue, root, n, target;
vector<int> adj[54];
int dfs(int here){
    int ret = 0;
    int child = 0;

    for(int there : adj[here]){
        if(there == target) continue; // 지울 노드면 뛰어넘기
        ret += dfs(there);
        child++;
    }
    if(child==0) return 1;
    return ret;
}

int main() {

    cin >> n;
    // 루트 노드 찾아서 지정
    for(int i=0; i<n; i++) {
        cin >> nodeValue;
        if(nodeValue == -1) {
            root = i; // 루트 노드가 몇번째 인지 root에 저장
        }
        else {
            // 부모 자식 연결 adj[0].push_back(1), adj[0].push_back(2) == 0번 노드에 1,2번이 달라 붙어있다는 뜻
            adj[nodeValue].push_back(i);
        }
    }
    
    cin >> target;
    // 지울노드가 루트 노드라면
    if(target == root) {
        cout << 0 << "\n";
        return 0;
    }
    cout << dfs(root) << "\n";
    return 0;
}

/**
 * 
5(노드 갯수 n)
-1 0 0 1 1 (노드들 -1은 root 노드)
2(지울 노드)
*/