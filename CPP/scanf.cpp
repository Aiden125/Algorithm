#include <bits/stdc++.h>
using namespace std;
int a;
double b;
char c;
/*
scanf는 주로 입력형식이 까다로울 때 사용
 d : int / c : char / s : string / lf : double / ld : long long
*/
int main() {
	scanf("%d %lf %c", &a, &b, &c);
	printf("%d\n", a);
	printf("%lf\n", b);
	printf("%c\n", c);
	return 0;
}
/*
입력
2330
233.233000
a

출력
2330
233.2330
a 
*/
