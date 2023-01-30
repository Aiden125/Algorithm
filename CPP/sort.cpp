#include <bits/stdc++.h>
using namespace std;

vector<int> a;
int b[5];

int main() {
	for(int i=5; i>=1; i--) {
		b[i -1] = i;
	}
	for(int i=5; i>=1; i--) {
		a.push_back(i);
	}
	
	// 오름차순 
	sort(b, b+5);
	sort(a.begin(), a.end());
	
	for(int i : b) {
		cout << i << ' ';
	}
	cout << '\n';
	
	for(int i : a) {
		cout << i << ' ';
	}
	cout << '\n';
	
	// 오름차순 
	sort(b, b+5, less<int>());
	sort(a.begin(), a.end(), less<int>());
	for(int i : b) {
		cout << i << ' ';
	}
	cout << '\n';
	
	for(int i : a) {
		cout << i << ' ';
	}
	cout << '\n';
	
	// 내림차순
	sort(b, b+5, greater<int>());
	sort(a.begin(), a.end(), greater<int>());
	for(int i : b) {
		cout << i << ' ';
	} 
	cout << '\n';
	for(int i : a) {
		cout << i << ' ';
	}
	cout << '\n';
	
	return 0;
}

/*
그냥 sort하거나 less<int>() 를 이용해서 오름차순으로,
greater<int>()를 사용해서 내림차순으로 정렬 가능하다. 

1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
5 4 3 2 1
5 4 3 2 1
*/
