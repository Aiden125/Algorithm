#include <bits/stdc++.h>
using namespace std;
/*
https://www.acmicpc.net/problem/2559
N : �µ��� ������ ��¥�� ��
K�� ���� ���ϱ� ���� ������ ��¥�� ��
N���� �µ���
*/
int N, K;
int temperture;
int temp;
int main() {
	cin >> N >> K;
	int arr[K];
	int max = 0;
	
	for(int i=0; i<K; i++) { // ù��° max�� ���ϱ� 
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
