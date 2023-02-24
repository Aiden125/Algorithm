#include <bits/stdc++.h>
using namespace std;

int n;
int main(){
    cin >> n;

    vector<int> v;
    int a;
    for(int i=0; i<n; i++) {
        cin >> a;
        v.push_back(a);
    }

    sort(v.begin(), v.end());
    
    int t = 0;
    int z = 0;
    int count = 0;
    // 1 2 3 3 4 ==> 1 3 6 9 13
    for(int i=0; i<v.size(); i++){
        z = v[i]; // 1 2 3 3 4
        count = count+z;
        t += count; // 1 4 
        // cout << v[i] << " ";
    }

    cout << t;
    return 0;
}