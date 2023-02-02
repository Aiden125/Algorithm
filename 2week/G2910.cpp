/**
 * map에 넣어서 출력
*/
#include<bits/stdc++.h>
using namespace std;

// mp는 {숫자, 횟수} 즉, 1 : 5번, 2:3번 이런식으로 몇 번 나왔는지
// mp_first는 {숫자, 인덱스} 즉, 어떤게 먼저 나왔는지 파악하기 위해 인덱스 번호 같이 저장
int n,c,a;
map<int, int> mp, mp_first; 
vector<pair<int, int>> vec;

bool cmp(pair<int, int> a, pair<int, int> b){ // 그냥 놔둘까? 라는 의미인듯(false 인 경우 첫째 둘째가 바뀜)
    if(a.first == b.first){ // 횟수가 같은 경우
        return mp_first[a.second] < mp_first[b.second]; // 먼저 나왔는지 비교, a(첫번째 인자)가 늦게 나왔으면(숫자가 더 크면) false 반환, false를 반환해서 첫째랑 둘째 순서를 바꿔야 한다는 의미
    }
    return a.first > b.first; // 횟수가 같지 않은 경우 a인자 횟수가 많으면 true(안바꿈), 적으면 false(바꿈) 선택
}
int main(){
    cin >> n >> c;
    for(int i=0; i<n; i++){
        cin >> a;
        mp[a]++; // 횟수 비교map에 ++
        if(mp_first[a] == 0) { // 처음 넣는 경우 인덱스정보 넣기
            mp_first[a] = i+1;
        }
    }
    for(auto it : mp){ // 벡터에 횟수, 숫자 순으로 넣기
        // cout << "\nit.seoncd : " << it.second << "it.first : " << it.first << "\n";
        vec.push_back({it.second, it.first}); // ex {10, 1} {5, 2} {7, 3}
    }
    // cout << "before sort\n";
    // for(auto i : vec){
    //     for(int j=0; j<i.first; j++){
    //         cout << i.second << ' ';
    //     }
    // }
    // cout << "\nbefore sort\n";
    sort(vec.begin(), vec.end(), cmp); // 나중에 다시 조금 더 들여다보기

    for(auto i : vec){
        for(int j=0; j<i.first; j++){
            cout << i.second << ' ';
        }
    }

    return 0;
}
