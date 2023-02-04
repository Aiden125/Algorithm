#include <bits/stdc++.h>
using namespace std;

list<int> a;
void print(list <int> a){
    for(auto it : a) cout << it << " ";
    cout << '\n';
}
int main() {
    for(int i=1; i<=3; i++){ // 1 2 3
        a.push_back(i);
    }
    for(int i=1; i<=3; i++){ // 3 2 1 1 2 3
        a.push_front(i);
    }
    auto it = a.begin(); // 맨앞을 잡음(array로 치면 인덱스0)
    it++;
    a.insert(it, 1000); // 3 1000 2 1 1 2 3
    print(a);
    it = a.begin();
    it++;
    a.erase(it); // 3 2 1 1 2 3
    print(a);

    a.pop_front(); // 2 1 1 2 3
    a.pop_back(); // 2 1 1 2
    print(a);

    a.pop_front(); // 1 2 2
    a.pop_back(); // 1 2
    print(a);

    cout << a.front() << " : " << a.back() << "\n";
    a.clear();

    return 0;

}
/*
3 1000 2 1 1 2 3 
3 2 1 1 2 3
2 1 1 2
1 1
1 : 1
*/