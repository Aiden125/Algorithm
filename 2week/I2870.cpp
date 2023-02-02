#include <bits/stdc++.h>
using namespace std;

int n;
string s;
vector<string> vec;
int main(){
    cin >> n;
    string sb = "";
    for(int i=0; i<n; i++){
        cin >> s;
        
        for(int j=0; j<s.length(); j++){
            char a = s[j];
            bool zero_check = true;
            if(a<65){
                if(a == '0' && zero_check){
                    continue;
                }else{
                    zero_check = false;
                    sb += a;
                }
            }
        }
        vec.push_back(sb);

        sort(vec.begin(), vec.end());
        for(int j=0; j<vec.size(); j++){
            cout << vec[j] << '\n';
        }
    }
    return 0;
}