/*
https://www.acmicpc.net/problem/2559
N, k
N���� �µ����� �־���

k�ϰ� �µ��� �ִ밪�� ���϶� 

ù k���� max���� ���ϰ� �Ϸ羿 �ڷ� ���鼭 max���� �ٲ���� üũ 
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
