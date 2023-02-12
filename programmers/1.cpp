/**
 * 순위 문제
 * 권투선수들의 순위를 구할 수 있는 선수의 수를 리턴(선수 100명 이하, 경기결과 4500개 이하)
*/
#include <bits/stdc++.h>
using namespace std;
bool a[101][101]; // 승리 표시표

int solution(int n, vector<vector<int>> results){
    int answer = 0;

    // 승리 결과에 따라 표시하기
    for(int i=0; i<results.size(); i++){
        a[results[i][0]][results[i][1]] = true;
    }

    for(int k=1; k<=n; k++) { // 중간노드
        for(int i=1; i<=n; i++) { // 시작노드
            for(int j=1; j<=n; j++) { // 도착노드
                if(a[i][j] && a[j][k]) {
                    a[i][k] = true;
                }
            }
        }
    }

    // i선수의 결과를 알 수 있는지 여부
    // 본인제외 모두 경기를 했다면 answer++
    for(int i=1; i<=n; i++) { 
        int count = 0;
        for(int j=1; j<=n; j++) {
            if(a[i][j] || a[j][i]) {
                count++;
            }
        }

        if(count == n-1) {
            answer++;
        }
    }

    return answer;
}