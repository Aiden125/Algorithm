#include <bits/stdc++.h>
using namespace std;
string s;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while(true){
        cin >> s;
        if(s == "end") break;

        bool a_check = true;
        bool b_check = false;
        bool c_check = false;
        
        int a_count = 0; // 자음 카운트
        int b_count = 0; // 모음 카운트
        for(int i=0; i<s.length(); i++){
            if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u'){
                a_check = false;
                a_count++;
                b_count = 0;
            }else{
                b_count++;
                a_count = 0;
            }
            if(a_count>=3 || b_count>=3) c_check = true;

            if(i!=0 && s[i] == s[i-1]){
                if(!(s[i]=='e' || s[i]=='o')){
                    b_check = true;
                }
            }
            
        }

        if(a_check || b_check || c_check) {
            cout << '<' << s << '>' << " is not acceptable.\n";
        }else{
            cout << '<' << s << '>' << " is acceptable.\n";
        }
    }
    return 0;
}