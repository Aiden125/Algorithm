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
int l; // ���� �� 
int r; // ������ ��
int temp; 
int main() {
	cin >> n >> m >> j;
	
	l = 1; 
	for(int i=0; i<j; i++){
	r = l + m -1; // �������� �� 
		cin >> temp;
		if(temp >= l && temp <= r) continue; //�׳� �־ �޾����� ��� 
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
