#include <bits/stdc++.h>
using namespace std;
/*
https://www.acmicpc.net/problem/2559
N : 온도를 측정한 날짜의 수
K는 합을 구하기 위한 연속적 날짜의 수
N개의 온도들
*/
int N, K;
int temperture;
int temp;
int main() {
	cin >> N >> K;
	int arr[K];
	int max = 0;
	
	for(int i=0; i<K; i++) { // 첫번째 max값 구하기 
		cin >> temperture;
		arr[i] = temperture;
		max += temperture;
	}
	temp = max;
	
	for(int i=K; i<N; i++) {
		cin >> temperture;
		
		
		temp = temp - arr[i%K] + temperture;
		arr[i%K] = temperture;
		
		if(temp > max) max = temp;
		
	}
	cout << max;
	
	return 0;
} 
