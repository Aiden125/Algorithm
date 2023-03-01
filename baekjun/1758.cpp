#include <bits/stdc++.h>
using namespace std;

int n, a;
vector<int> v;
int main() {
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> a;
        v.push_back(a);
    }
    sort(v.begin(), v.end(), greater<int>());

    long long total = 0;
    for(int i=0; i<v.size(); i++){
        int tip = v[i] - i;
        if(tip > 0){
            total += tip;
        }
    }

    cout << total;

    return 0;
}