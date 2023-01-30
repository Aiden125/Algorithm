#include <bits/stdc++.h>
using namespace std;

// 배열의 크기를 정할 때 const int로 하면 실수 방지 가능
// 어떤 순간에는 1004, 1000 이렇게 사용자의 실수를 방지 
const int max_n = 1004;
// 초기화 같이 길 경우 const로 선언해 놓는게 좋음
const int INF = 987654321;

// vector 10개 생성 
vector<int> v[10];
// 초기값이 0인 vector 1개 생성 
vector<int> v2(10, 0);
// 크기 10 * 10, 초기값은 0인 2차원 vector 생성 
vector <vector<int> > v3(10, vectore<int>(10, 0)); 
// 크기가 정해지지 않은 2차원 vector 생성
vector<vector<int> > v4;

// 1차원 배열을 만들어 0으로 초기화
// 일부 컴파일러에서 통하지 않을 수 있음 
int dp[10] = {0,};

// 1차원 배열 a, 2차원 배열 a2 
int a[max_n];
int a2[max_n][max_n];

int main() {
	// 이터레이터 기반으로 초기화
	fill(v2.begin(), v2.end(), INF);
	// 10으로 초기화, 1004까지 전체적으로 초기화
	fill(a, a + max_n, 10);
	// fill을 이용한 2차원 배열 초기화
	fill(&a2[0][0], &a2[0][0] + max_n * max_n, INF);
	
	return 0; 
} 

/*
fill = 배열 초기화 
*/
