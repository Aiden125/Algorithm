#include <bits/stdc++.h>
using namespace std;

int n, s, e;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    
    vector<pair<int, int>> v;
    for(int i=0; i<n; i++){
        cin >> s >> e;
         v.push_back({e, s});
    }
    // 오름차순, 오름차순으로 sorting
    sort(v.begin(), v.end());

    int t = v[0].first;
    int count = 1;
    for(int i=1; i<v.size(); i++){
        if(t <= v[i].second){
            count++;
            t = v[i].first;
        }
    }
    
    cout << count << "\n";
    

    return 0;
}