// 가장 먼 노드 https://school.programmers.co.kr/learn/courses/30/lessons/49189?language=cpp
#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> graph[20004];
vector<int> counts[20004];
vector<int> visited[20004];
int a, b; // node 1,2
int root;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;

    for(int i=0; i<n; i++){
        // 입력 받는 법 기억하기
        int a = edge[i][0];
        int b = edge[i][1];

        graph[a].push_back(b);
        graph[b].push_back(a);

        if(a==1) root = i;
    }


    

    return answer;
}

int main(){

    return 0;
}