#include <bits/stdc++.h>
using namespace std;
int a, b;
double c;
int main() {
	scanf("%d.%d", &a, &b);
	printf("\n%d %d\n", a, b);
	
	scanf("%lf", &c);
	printf("%lf\n", c);
	return 0;
}
/*
scanf를 활용해 실수타입을 정수타입으로 받을 수 있다.
double 타입으로 들어오는것을 int 타입 2개로 받을 수 있다. 
입력 
3.22
3.22

출력 
3 22
3.220000
*/
