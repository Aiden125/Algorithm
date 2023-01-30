#include <bits/stdc++.h>
using namespace std;
map<string, int> mp;
string a[] = {"문희석", "문희문", "석희문"};
int main() {
    for(int i=0; i<3; i++){
        mp.insert({a[i], i+1});
        mp[a[i]] = i+1;
    }
    // mp에 해당키가 없다면 0으로 초기화 되어 할당(int의 경우)
    // 만약 mp에 해당 키가 없는지 확인하고 싶고
    // 초기값으로 0으로 할당되지 않아야 되는 상황이라면
    // find를 써야함
    cout << mp["moon"] << '\n'; // == 0
    mp["moon"] = 4;// 수정
    cout << mp.size() << '\n'; // == 4
    mp.erase("moon"); // 지우기

    auto it = mp.find("moon");
    if(it == mp.end()){ // 없으면 mp.end()반환
        cout << "못 찾음\n"; // == 그대로 출력
    }
    mp["moon"] = 100;

    it = mp.find("moon");
    if(it != mp.end()){
        cout << (*it).first << " : " << (*it).second << '\n';
    }
    for(auto it : mp){
        cout << (it).first << " : " << (it).second << '\n';
    }
    for(auto it = mp.begin(); it != mp.end(); it++){
        cout << (*it).first << " : " << (*it).second << '\n';
    }
    mp.clear();
    
    return 0;
}