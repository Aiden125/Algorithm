#include <bits/stdc++.h>
using namespace std;

int n;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    long long diss[n];
    long long costs[n];
    for(int i=0; i<n-1; i++){
        cin >> diss[i];
    }
    for(int i=0; i<n; i++){
        cin >> costs[i];
    }

    long long totalCost = 0;
    long long minCost = INFINITY;
    long long prefixDis = 0;
    for(int i=0; i<n-1; i++){
        if(costs[i] < minCost){// 이번 주유소가 더 싸면
            minCost = costs[i];
            totalCost += costs[i] * diss[i];
        }else{// 이번 주유소가 더 비싸면
            totalCost += minCost * diss[i];
        }
    }
    // 1. 5 <= 999
    // 1. total = 5*2
    // 2. 2 <= 5
    // 2. total = 10 

    cout << totalCost;

    return 0;
}