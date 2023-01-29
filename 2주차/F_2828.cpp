#include <bits/stdc++.h>
using namespace std;
/*
1. 바구니가 이동하는 거리 최소값
2. DFS? 
*/ 
int n; // 스크린 길이 
int m; // 바구니 길이 가장 왼쪽에 위치 
int j; // 사과 갯수
int dis; // 출력값(총 이동거리)
int a; // 앞의 값 
int b; // 뒤의 값 
int main() {
	cin >> n >> m >> j;
	
	cin >> a;
	for(int i=1; i<j; i++){
		cin >> b;
		dis += abs(a-b) - (m-1);
		a = b;
	}
	cout << dis;
	
	return 0;
} 
