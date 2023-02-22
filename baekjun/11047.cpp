#include <bits/stdc++.h>
using namespace std;

int m, n;
int main(){
    cin >> n >> m;
    int a[n];
    int count=0;
    
    
    for(int i=0; i<n; i++){
        cin >> a[i];
    }

    for(int i=n-1; i>=0; i--){
        int b = a[i];
        if(m>=b){
            int c = m/b;
            count = count + c;
            m = m%b;
            if(m==0) break;
        }
    }

    cout << count << "\n";

    

    

    return 0;
}