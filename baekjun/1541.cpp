#include <bits/stdc++.h>
using namespace std;

string s;
int main() {
    cin >> s;
    string a = "";
    vector<int> v;
    for(int i=0; i<s.size(); i++){
        if(s[i] == '+'){
            v.push_back(stoi(a));
            a = "";
        }
        if(s[i] == '-'){

        }

        a = a + s[i];
        
    }
    return 0;
}