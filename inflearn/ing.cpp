#include <bits/stdc++.h>
using namespace std;

int n, k;
vector<int> v;
vector<int> answer;
int main() {
    cin >> n;
    cin >> k;
    
    for(int i=0; i<n; i++) {
        int a;
        cin >> a;
        v.push_back(a);
    }
    for(int i=0; i<=n-k; i++) {
        map<int, int> a;
        for(int j=i; j<i+k; j++) {
            a[v[j]]++;
        }
        int si = a.size();
        answer.push_back(si);
    }
    for(auto a : answer) {
        cout << a << " ";
    }
    
}