#include <bits/stdc++.h>
using namespace std;

int n;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;

    int num = 665;
    int cnt = 0;
    while(true){
        num++;
        string s = to_string(num);
        auto it = s.find("666");
        if(it != string::npos){ // 원하는게 있으면
            cnt++;
        }

        if(cnt==n) break;
    }
    cout << num << "\n";
    return 0;
}