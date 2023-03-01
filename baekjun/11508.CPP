#include <bits/stdc++.h>
using namespace std;

int n, a;
vector<int> v;
int main() {
    cin >> n;
    int totalCost = 0;
    for(int i=0; i<n; i++){
        cin >> a;
        totalCost += a;
        v.push_back(a);
    }
    // 내림차순으로 정렬
    sort(v.begin(), v.end(), greater<int>());

    int free = 0;
    for(int i=0; i<v.size(); i++){
        if(i%3 == 2){
            free += v[i];
        }
    }
    // 3 3 2 2 Vsize = 4
    cout << totalCost-free;
    return 0;
}