#include <bits/stdc++.h>
using namespace std;

int n, m;
int a, b;
vector<int> v[10001];
int dp[10001], visited[10001], mx;

int dfs(int here){
    visited[here] = 1;
    int ret = 1;

    // 해당 번호에 신뢰하는 애가 없으면 for문 자체를 안돌음
    for(int there : v[here]){
        if(visited[there]) continue;
        ret += dfs(there);
    }
    
    return ret;
}
int main() {
    cin >> n >> m;

    // 입력받기 b에 a를 달아준다
    while(m--) {
        cin >> a >> b;
        v[b].push_back(a);
    }

    // 배열 초기화 및 dfs, mx돌기
    for(int i=1; i<=n; i++){
        memset(visited, 0, sizeof(visited)); // 초기화 int값이라 memset 가능
        dp[i] = dfs(i); // dp의 인덱스에 몇개가 신뢰하는지 저장 1부터 n번까지 다 돌음
        mx = max(dp[i], mx); // max값을 mx로 저장
    }

    for(int i=1; i<=n; i++){
        if(mx==dp[i]) {
            cout << i << " ";
        }
    }
}