#include <bits/stdc++.h>
using namespace std;

int main() {
	string a = "love is";
	a += " pain!";
	a.pop_back(); // 마지막 글자 날림 O(1)
	
	cout << a << " : " << a.size() << "\n";  // love is pain : 12  O(n)
	cout << char(* a.begin()) << '\n'; // 처음꺼 하나 반환 l
	cout << char(* (a.end() -1)) << '\n'; // 마지막으로 포인터 가져다 놓고 반환  n
	
	a.insert(0, "test "); // 해당 인덱스에 문자열 삽입 O(n)
	cout << a << " : " << a.size() << "\n"; // test love is pain : 17  O(n)
	
	a.erase(0, 5); // 해당 인덱스부터 문자열 지우기 O(n)
	cout << a << " : " << a.size() << "\n"; // love is pain : 12
	
	auto it = a.find("love"); // love가 있으면 string::npos를 반환 
	if (it != string::npos) { // string::npos란 size_t 타입의 최대값으로 64비트 기준 184467440~~ 
		cout << "포함되어 있다." <<  '\n';
	}
	
	cout << it << '\n'; // ??
	cout << string::npos << '\n';
	
	cout << a.substr(5, 2) << '\n';
	
	return 0;
}
/*
love is pain : 12
l
n
test love is pain : 17
love is pain : 12
포함되어 있다.
0
18446744073709551615
is 
*/
