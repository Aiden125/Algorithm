#include <bits/stdc++.h>
using namespace std;

int a[101][101], visited[101][101], zone[101][101];
int m, n, air_cheese, total_cheese, hours;
pair<int, int> blocked_wall;
vector<int, int> vec;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
bool blocked_zone = true;

void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i=0; i<4; i++){
        int ny = y+dy[i];
        int nx = x+dx[i];

        blocked_wall.first = y;
        blocked_wall.second = x;
        vec.pop_back({y, x});
        if(ny<0 || nx<0 || ny>=m || nx>n) {
            blocked_zone = false;
            continue;
        }
        if(visited[ny][nx] && a[ny][nx]!=0) continue;
        dfs(ny, nx);
    }

    return;
}
int main() {
    cin >> m >> n; // 세로, 가로
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            cin >> a[i][j];
        }
    }

    // // 갇혀있는 공기 존 구하기
    // for(int i=0; i<m; i++){
    //     for(int j=0; i<n; i++){
    //         if(a[i][j]==0 && visited[i][j] != 1) {
    //             dfs(i, j);
    //             if(blocked_zone){
    //                 for(int k=0; k<blocked_wall.; k++){

    //                 }
    //                 for(auto it : blocked_wall()){
                        
    //                 }
    //             }
    //             fill(&zone[0][0], &zone[0][0] + 100 * 100, 0);
                
    //         }
    //     }
    // }
    
    return 0;
}

/**
 * 처음 생각. 치즈 안쪽의 벽을 치즈라고 생각한 뒤 구하면 어떨까?
 * 
 * 진짜 풀이. 벽이 dfs를 하는데 치즈를 만나면 막히고 visited가 되게
*/