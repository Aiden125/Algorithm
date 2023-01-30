#include <bits/stdc++.h>
using namespace std;

// split 메서드 O(n)
vector<string> split(string input, string delimiter) {
	vector<string> ret;
	long long pos = 0;
	string token = "";
	
	// ★★들어온 문자열을 자를기준이 있는지 체크★★ 
	while((pos = input.find(delimiter)) != string::npos) {
		token = input.substr(0, pos); // 자른걸 토큰으로 저장 
		ret.push_back(token); // 토큰을 ret에 삽입 
		input.erase(0, pos + delimiter.length()); // 인풋에서 넣은거만큼 잘라버림 
	}
	
	ret.push_back(input); // 잘린 결과물이 담긴 배열 리턴(길이는 자른횟수+1) 
	return ret;
}

int main() {
	string s = "안녕하세요 오늘 날씨가 정말 춥네요!";
	vector<string> a = split(s, " "); // 인풋, 자를 단위 
	for(string b : a) { // 받아온 배열 for문 
		cout << b << "\n";
	}
}

/*
직접 split을 만들어야 하며 핵심만 기억하면 쉽다. 
*/
