#include <bits/stdc++.h>
using namespace std;

string s;
int main() {
    cin >> s;
    s = regex_replace(s, regex("XXXX"), "AAAA");
    s = regex_replace(s, regex("XX"), "BB");

    // string::npos 대신 -1을 써도 안전한가?
    if(s.find("X") != string::npos){// X가 있으면
        cout << "-1";
    }else{// X가 없으면
        cout << s;
    }
}