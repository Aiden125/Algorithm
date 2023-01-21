#include <bits/stdc++.h>
using namespace std;

int N;
string s;

int main()
{
    cin>>N;
    int cnt = 0;
    
    for(int i=0; i<N; i++) {
        cin>>s;
        
        if(s.length() & 1) continue; // 홀 수 인 경우
        
        bool check = true;
        char temp1 = 'z';
        char temp2 = 'z';
        for(int j=0; j<s.length(); j++) {
            if(temp1=='z' && temp2=='z'){
            	temp1 = s[j];
            	continue;
			}else if(temp1!='z' && temp2=='z'){
				if(temp1==s[j]){
					temp1='z';
					continue;
				}else{
					temp2=s[j];
				}
			}else if(temp1!='z' && temp2!='z'){
				if(temp2==s[j]){
					temp2='z';
				}else{
					check = false;
					break;
				}
			}
        }
        cout << "\n\n\n\n";
        cout << "temp1 : " << temp1 << "temp2 : " << temp2 << "\n";
        
        if(temp1=='z' && temp2=='z' && check){
        	cnt++;
		}
        
    }
    cout << cnt << '\n';

    return 0;
}
