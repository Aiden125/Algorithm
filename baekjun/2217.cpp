#include <bits/stdc++.h>
using namespace std;

int n, rope;

vector<int> v;

int main() {
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> rope;
        v.push_back(rope);
    }
    // 내림차순으로 정렬
    sort(v.begin(), v.end(), greater<int>());

    int total = 0;
    int max = 0;

    for(int i=0; i<n; i++){
        total = v[i] * (i+1);
        if(max < total){
            max = total;
        }
    }
    cout << max;

    return 0;
}