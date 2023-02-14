#include <bits/stdc++.h>
using namespace std;

vector<int> a[54];
int n;
int parentNode; // 부모 노드
int root; // 루트 위치
int target;
int answer;

int dfs(int here){
    int result = 0;
    bool childCheck = false;

    // 이 for문을 돈다는 것은 자식이 있다는 것
    for(int there : a[here]){
        if(target == there) continue;
        result += dfs(there);
        childCheck = true;
    }
    if(childCheck==false) return 1;

    return result;
}

int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> parentNode;
        if(parentNode == -1) root = i;// 루트면 위치 지정
        else a[parentNode].push_back(i); // 루트가 아니면 부모에게 달아주자
    }

    cin >> target;
    
    if(target == root) {
        cout << 0 << "\n";
        return 0;
    }
    else {
        answer = dfs(root);
        cout << answer << "\n";
    }

    return 0;
}