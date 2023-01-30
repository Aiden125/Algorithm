#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main() {
	for(int i = 1; i<=5; i++) {
		v.push_back(i); // 1, 2, 3, 4, 5
	}
	
	for(int i=0; i<5; i++) {
		cout << i << "번째 요소 : " << *(v.begin() + i) << "\n";
		cout << &*(v.begin() + i) << "\n";
	}
	for(auto it = v.begin(); it != v.end(); it++) {
		cout << *it << ' ';
	}
	
	cout << "\n";
	
	for(vector<int>::iterator it = v.begin(); it != v.end(); it++) {
		cout << *it << ' ';
	}
	
	auto it = v.begin();
	advance(it, 3);
	cout << "\n";
	cout << *it << "\n";
	
	return 0;
}
/*
이터레이터란?  컨테이너에 저장되어 있는 요소의 주소를 가리키는 객체 
*/

/*
begin() : 컨테이너의 시작 위치 반환
end() : 컨테이너의 끝 다음 위치를 반환
advance(iterator, cnt) : 해당 iterator를 cnt까지 증가시킵니다. 

 
0번째 요소 : 1
0x1a1530
1번째 요소 : 2
0x1a1534
2번째 요소 : 3
0x1a1538
3번째 요소 : 4
0x1a153c
4번째 요소 : 5
0x1a1540
1 2 3 4 5
1 2 3 4 5
4
*/
