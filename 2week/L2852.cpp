#include<bits/stdc++.h>
using namespace std;
/**
 * 1. 1인지 2인지 구분
 * 2. 분과 초를 나눠준다.
*/
int n;
string a, t;
int a_count, b_count;
int a_m, a_s, b_m, b_s;
int t_m = 48, t_s=0;
void go(int m, int s){

        if(s > t_s) {
            t_s = 60 - s;
            t_m = t_m - m -1;
        }else{
            t_m -= m;
        }
}
int main(){
    cin >> n;
    
    for(int i=0; i<n; i++){
        cin >> a >> t;
        if(a=="1") a_count++;
        else if(a=="2") b_count++;

        int m = t[0]+t[1];
        int s = t[3]+t[4];
        go(m, s);

        if(a_count>b_count){
            a_m = t_m;
            a_s += t_s;
        }else if(b_count>a_count){
            b_m += t_m;
            b_s += t_s;
            if(a_m != 0 || a_s != 0){

            }
            a_m -= b_m;
        }



    }
    return 0;
}