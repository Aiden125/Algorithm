## C++ grammer

## 가장 기본적인 예제
```C++
#include <bits/stdc++.h>
using namespace std;
string a;
int main() {
    cin >> a;
    cout << a << "\n";
    return 0;
}
```

## 헤더파일
```C++
#include <bits/stdc++.h>
```
위 include는 C++의 모든 표준 라이브러리가 포함된 헤더파일이며, 이를 include 하겠다는 뜻

## namespace
라이브러리를 디폴트로 고정하는 것
원래 std::cin 이렇게 호출해야하는 것을 cin, cout 등으로 바로 호출 할 수 있게 설정

## typedef
타입을 약어로 지정

## define
상수, 매크로 정의

## 입력과 출력
#### 입력
- cin : 개행문자까지 입력 받기
- scanf : 형식 지정 입력 받기
- geline : 한 줄 입력 받기
#### 출력
- cout : 기본 출력
- printf : 형식지정 출력

## scanf로 받을 수 있는 타입 형식
d : int / c : char / s : string / lf : double / ld : long long

## precision
precision(7) 소수 7번째 자리에서 반올림하라

## 자주 등장하는 타입 7가지
```C++
void, char, string, bool, int, long long, double
```
- void : 리턴하는 값이 x
- char : 1바이트 문자
- string : 문자열(영어, 숫자1바이트, 한글 3바이트)
- bool : 0이면 false, 0이 아니면 모두 true
- int : 4바이트, 대략20억까지, const int INF2 = le0;
- long long : 8바이트, 숫자 제한이 없다봐도 무방, ll INF = 1e18;
- double : 실수, 8바이트, 소수점 아래 15까지(float은 7자리까지)

## string method
- a.pop_back() : 맨 뒤 하나 지우기
- a.begin() : 포인터가 맨앞을 가리킴
- a.end() : 포인터가 맨뒤를 가리킴(마지막 글자원하면 -1 해주기)
- a.size() : a문자열의 사이즈
- a.fine("love") : love라는 문자가 있으면 string::npos 반환
- a.substr(5,2) : 5번째 위치부터 2칸 추출
- 아스키코드 : A(65), a(97)
- reverse() : 문자열 뒤집기
- split() : C++은 split을 직접만들어서 써야하며 코드 꼭 기억하기
```C++
while ((pos = input.find(delimiter)) != string::npos) {
token = input.substr(0, pos);
ret.push_back(token);
input.erase(0, pos + delimiter.length());
}
ret.push_back(input);
return ret;
```
- atoi(s.c_str) : s가 문자열이면 0반환 그게 아니면 숫자 반환

## 오버플로 언더플로
- 오버플로 : 타입의 허용범위 넘어갈 때 발생하는 에러
- 언더플로 : 타입의 허용범위 아래로 내려갈 때 발생하는 에러


## auto
타입추론을 해서 결정되는 타입. 특별히 어떤 타입이라고 지정하는 것이 아닌 유추 할 수 있게 만들어주는 타입

## 역참조 연산자
'*'를 에스터리스크(asterisk operator)라고 부르며, 이를 포인터 타입 선언, 역참조, 곱셉 연산 등으로 활용 가능
```C++
#include<bits/stdc++.h>
using namespace std;
int main(){
string a = "abcda";
string * b = &a;
cout << b << "\n";
cout << *b << "\n";
return 0;
/*
0x6ffdf0
abcda
*/
}

```

## 이터레이터
컨테이너에 저장되어 있는 요소의 주소를 가리키는 객체이며, begin(), end(), advance(iterator, cnt)와 자주 쓰임
- begin() : 컨테이너의 시작 위치 반환
- end() : 컨테이너의 끝 다음 위치 반환
- advance(iterator, cnt) : 해당 iterator를 cnt까지 증가

## sort
정렬인데 그냥 sort하거나 less<int>() 를 이용해서 오름차순으로,
greater<int>()를 사용해서 내림차순으로 정렬 가능하다. 

- 기본 오름차순
- pair로 이루어진 vector는 first, second, third 순으로 정렬
- 3번째 요소까지 정렬 원한다면 sort(a[0], a[0]+3) 즉, 포인터 앞까지 정렬해줌

## map
- key는 자동 오름차순 정렬
- 중복된 값 안들어감
- 조회만 해도 0이나 빈 문자가 들어감
- mp.find(a) a를 찾았는데 없으면 end() 반환
- mp.find(), mp.erase(), mp.clear(), mp[]=1

```C++
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
    if(it != mp.end()){
        cout << (*it).first << " : " << (*it).second << '\n'; // moon : 100
    }
    for(auto it : mp){
        cout << (it).first << " : " << (it).second << '\n'; // a : 1  b : 2 c : 3 moon : 100
    }
    for(auto it = mp.begin(); it != mp.end(); it++){ // a : 1  b : 2 c : 3 moon : 100
        cout << (*it).first << " : " << (*it).second << '\n';
    }
    mp.clear();
    
    return 0;
}
```

## string find
- 못찾으면 string::npos 리턴
```C++
auto it = a.find("love");
if (it != string::npos){
cout << "포함되어 있다." << '\n';
}
```

<br><br>
array 있는 페이지부터 시작 