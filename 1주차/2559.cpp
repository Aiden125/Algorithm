/*
https://www.acmicpc.net/problem/2559
N, k
N개의 온도값이 주어짐

k일간 온도의 최대값을 구하라 

첫 k일의 max값을 구하고 하루씩 뒤로 가면서 max값이 바뀌는지 체크 
*/
#include <bits/stdc++.h>
using namespace std;

int N, k, temperature;

int main() {
	cin >> N;
	cin >> k;
	int arr[k];
	int max = 0;
	
	for(int i=0; i<k; i++) {
		cin >> temperature;
		max += temperature;
		arr[i] = temperature;
	}
	int temp = max;
	
	for(int i=k; i<N; i++) {
		cin >> temperature;
		temp = temp + temperature - arr[i%k];
		if(temp > max) max = temp;
		arr[i%k] = temperature;
	}
	
	cout << max;
}
