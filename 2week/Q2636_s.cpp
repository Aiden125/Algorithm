#include <bits/stdc++.h>
using namespace std;

int a[101][101], visited[101][101];
int m, n, hours, cheese_num;
vector <pair<int, int>> v;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

void dfs(int y, int x){
    visited[y][x] = 1;

    // 썩는 치즈
    if(a[y][x] == 1){
        v.push_back({y,x}); 
        return;
    }
    
    // 추가 dfs
    for(int i=0; i<4; i++){
        int ny = y+dy[i];
        int nx = x+dx[i];
        
        if(ny<0 || nx<0 || ny>=n || nx>=m || visited[ny][nx]==1) continue;
        dfs(ny, nx);
    }

    return;
}
int main(){
    // 입력받기
    cin >> n >> m; 
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> a[i][j];
        }
    }
    
    while(true){
        // 초기화. 치즈 갯수, 방문 바둑판, 썩는 치즈
        cheese_num = 0;
        fill(&visited[0][0], &visited[0][0] + 101*101, 0);
        v.clear();

        //dfs시작
        dfs(0, 0);
        
        // 썩는 치즈 구하기 및 썩히기
        for(pair<int, int> b : v){ // v에 썩는 치즈 인덱스가 다 들어있는 상황
            cheese_num++; // 썩는 치즈 갯수
            a[b.first][b.second] = 0; // 바로 초기화
        }
        hours++;

        // 치즈 남아있는지 체크
        bool flag = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i][j]!=0) flag = 1;
            }
        }
        
        if(!flag) break; // 모두 다 썩었으면 break

    }

    cout << hours << "\n" << cheese_num << "\n";

    return 0;
}