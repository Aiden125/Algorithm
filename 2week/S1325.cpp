#include <bits/stdc++.h>
using namespace std;

map<int, int> mapp; // 신뢰하는 컴퓨터 수
vector<int> vec[10004]; // 컴퓨터 노드
int c1, c2; // 컴퓨터
int n; // 컴퓨터 최대 수
int m; // m번 줄에 걸쳐 들어옴
vector<int> resultVec;

int dfs(int here){
    int result = 0;
    bool childCheck = false;
    
    for(int there : vec[here]){
        result += dfs(there);
        childCheck = true;
    }
    if(childCheck) return 1;

    return result;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> m;

    for(int i=0; i<m; i++){
        cin >> c1 >> c2;
        mapp.insert(c2, 1);
        vec[c1].push_back(c2);
    }

    int max = -999;
    for(auto it : vec){

        int a = dfs("3"); // 벡터 순회하는 것 잘 모르겠음
        if(a >= max){
            resultVec.push_back(a);
        }
    }

    for(int i=0; i<vec.size(); i++){
        cout << vec[i] << "\n";
    }

    
    
    return 0;
}

// 과제
// 1. 벡터 순회시키는 법