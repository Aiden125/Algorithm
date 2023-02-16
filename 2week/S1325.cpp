#include <bits/stdc++.h>
using namespace std;

vector<int> vec[10004]; // 컴퓨터 노드
int cNum[10004], visited[10004]; // 컴퓨터 넘버, 방문표시
int c1, c2; // 컴퓨터
int n; // 컴퓨터 최대 수
int m; // m번 줄에 걸쳐 들어옴
int maxx;
vector<int> resultVec;

// 3. dfs 순회 int타입
int dfs(int here){
    int result = 1;
    visited[here] = 1;

    // 신뢰하는 컴퓨터 수가 있어야 for문 돌음
    for(int there : vec[here]){
        if(visited[there]) continue;
        result += dfs(there);
    }
    
    return result;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    // 1. 입력받기
    for(int i=0; i<m; i++){
        cin >> c1 >> c2;
        vec[c2].push_back(c1);
    }

    // 2. 초기화, cNum 배열에 결과 저장
    for(int i=1; i<=n; i++){
        memset(visited, 0, sizeof(visited));
        cNum[i] = dfs(i); // cNum에 할당
        maxx = max(cNum[i], maxx);
    }

    // 4. 최대값 출력
    for(int i=1; i<=n; i++){
        if(cNum[i] == maxx){
            cout << i << " ";
        }
    }
    
    return 0;
}
