#include <bits/stdc++.h>
using namespace std;
/**
 * m : height , n : width , k : 직사각형 갯수
 * 직사각형이 없는 곳의 넓이를 구하라
*/
#define y1 aaa
int x1,x2,y1,y2;
int m,n,k;
int a[101][101], visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<int> ret;
int dfs(int y, int x){
    visited[y][x] = 1;
    int cnt=1;
    for(int i=0; i<4; i++){
        int ny = y+dy[i];
        int nx = x+dx[i];
        if(ny<0 || nx<0 || ny>=m || nx>=n) continue;
        if(visited[ny][nx]==1 || a[ny][nx]==1) continue;
        cnt += dfs(ny, nx);
    }
    return cnt;
}
int main() {
    cin >> m >> n >> k;
    // 입력 및 색칠
    while(k--){
        cin >> x1 >> y1 >> x2 >> y2;
        for(int x=x1; x<x2; x++){
            for(int y=y1; y<y2; y++){
                a[y][x] = 1;
            }
        }
    }

    for(int i=0; i<m; i++){ // 세로
        for(int j=0; j<n; j++){ // 가로
            if(!a[i][j] && !visited[i][j]){
                ret.push_back(dfs(i, j));
            }
        }
    }
    
    sort(ret.begin(), ret.end());
    cout << ret.size() << "\n";
    for(int a : ret) {
        cout << a << " ";
    }

    return 0;
}

/**
 * 커넥티드 컴포넌트 --> dfs 사용
 * 
*/