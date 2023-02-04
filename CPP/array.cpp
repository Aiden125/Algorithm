#include <bits/stdc++.h>
using namespace std;
int a[3] = {1,2,3};
int a2[] = {1,2,3,4};
int a3[10];
int main() {
    for(int i=0; i<3; i++){
        cout << a[i] << " "; // 1 2 3
    }
    cout << '\n';

    for(int i : a){
        cout << i << " "; // 1 2 3
    }
    cout << '\n';

    for(int i=0; i<4; i++){
        cout << a2[i] << " ";  // 1 2 3 4
    }
    cout << "\n";

    for(int i : a2){
        cout << i << " "; // 1 2 3 4
    }
    cout << '\n';
    
    for(int i=0; i<10; i++){
        a3[i] = i;
    }
    cout << "\n";

    for(int i : a3){
        cout << i << " "; // 1 2 3 4 5 6 7 8 9 10
    }
}
/**
1 2 3 
1 2 3
1 2 3 4
1 2 3 4
0 1 2 3 4 5 6 7 8 9
*/