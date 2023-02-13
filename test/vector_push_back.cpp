#include <bits/stdc++.h>
using namespace std;

int temp, root, n, r;
vector<int> adj[54];
/*
벡터 배열을 만들어 특정 인덱스에 push_back을 할 수 있다.
*/
int main() {
    for(int i=0; i<5; i++) {
        adj[1].push_back(i);
    }
    for(int i=0; i<5; i++) {
        adj[2].push_back(i+10);
    }
    for(auto it : adj[2]){
        cout << it << "\n";
    }
    for(auto it : adj[2]){
        cout << it << "\n";
    }
    return 0;
}