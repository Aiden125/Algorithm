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
int l; // 왼쪽 값 
int r; // 오른쪽 값
int temp; 
int main() {
	cin >> n >> m >> j;
	
	l = 1; 
	for(int i=0; i<j; i++){
	r = l + m -1; // 오른쪽의 끝 
		cin >> temp;
		if(temp >= l && temp <= r) continue; //그냥 있어도 받아지는 경우 
		else{
			if(temp < l){
				dis += (l-temp);
				l = temp;
			}else{
				l += (temp-r);
				dis += (temp-r);
			}
		}
	}
	cout << dis;
	
	return 0;
} 
