#include <bits/stdc++.h>
using namespace std;
/*
1. �ٱ��ϰ� �̵��ϴ� �Ÿ� �ּҰ�
2. DFS? 
*/ 
int n; // ��ũ�� ���� 
int m; // �ٱ��� ���� ���� ���ʿ� ��ġ 
int j; // ��� ����
int dis; // ��°�(�� �̵��Ÿ�)
int a; // ���� �� 
int b; // ���� �� 
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
