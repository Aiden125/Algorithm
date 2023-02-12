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

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            for(int k=1; k<=n; k++) {
                if(a[j][i] && a[i][k]) {
                    a[j][k] = true;
                }
            }
        }
    }

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