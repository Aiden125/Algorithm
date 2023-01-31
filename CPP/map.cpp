#include <bits/stdc++.h>
using namespace std;
map<string, int> mp;
string a[] = {"a", "b", "c"};
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
        cout << "cannot find\n"; // == 그대로 출력
    }
    mp["moon"] = 100;

    it = mp.find("moon");
    if(it != mp.end()){ // 없는경우 맨 끝 반환.
        cout << (*it).first << " : " << (*it).second << '\n'; // moon : 100
    }
    for(auto it : mp){ // 받은 이터레이터 반복
        cout << (it).first << " : " << (it).second << '\n'; // a : 1  b : 2 c : 3 moon : 100
    }
    // 받은 이터레이터 반복
    for(auto it = mp.begin(); it != mp.end(); it++){ // a : 1  b : 2 c : 3 moon : 100
        cout << (*it).first << " : " << (*it).second << '\n';
    }
    mp.clear();
    
    return 0;
}