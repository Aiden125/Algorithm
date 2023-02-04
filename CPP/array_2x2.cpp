#include <bits/stdc++.h>
using namespace std;
const int mxy =3;
const int mxx =4;

int a[mxy][mxx];
int main() {
    for(int i=0; i<mxy; i++){
        for(int j=0; j<mxx; j++){
            a[i][j] = (i + j);
        }
    }
    
    //good
    for(int i=0; i<mxy; i++){
        for(int j=0; j<mxx; j++){
            cout << a[i][j] << ' ';
        }
        cout << '\n';
    }

    //bad
    for(int i=0; i<mxx; i++){
        for(int j=0; j<mxy; j++){
            cout << a[j][i] << ' ';
        }
        cout << '\n';
    }
}

/**
 * 첫번째 원소, 두번쨰 원소 순으로 탐색하는게 가장 좋다.
0 1 2 3 
1 2 3 4
2 3 4 5
0 1 2
1 2 3
2 3 4
3 4 5
*/