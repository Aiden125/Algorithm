#include<bits/stdc++.h>
using namespace std;

int n;
vector<string> vec;
string s,ret;
void go(){
    while(true){
        if(ret.size() && ret.front() == '0'){
            ret.erase(ret.begin());
        }else{
            break;
        }
    }
    if(ret.size() == 0){
        ret = "0";
    }
    vec.push_back(ret);
    ret = "";

}

bool cmp(string a, string b){ // 문자열인데 어떻게 정렬..? -> 아스키 코드 기반으로
    if(a.size() == b.size()) return a<b; // 2순위
    return a.size() < b.size(); // b사이즈가 더 크면 안바꿈(true면 안바꿈)
}
int main(){
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s;
        ret = "";
        for(int j=0; j<s.size(); j++){
            if(s[j] < 65){
                ret += s[j];
            }else if(ret.size()){
                go();
            }
        }
        if(ret.size()){
            go();
        }
    }

    sort(vec.begin(), vec.end(), cmp);
    for(string i : vec){
        cout << i << "\n";
    }
}