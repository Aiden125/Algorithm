#include <bits/stdc++.h>
using namespace std;

int a = 1;
char s = 'a';
string str = "어벤져스";
double b = 1.221234;

int main() {
	printf("i am a ironman : %d\n", a); // 1
	printf("i am a ironman : %c\n", s); // a
	printf("i am a ironman : %s\n", str.c_str()); // 어벤져스 
	printf("i am a ironman : %lf\n", b); // 1.221234
	return 0;
}

/*
문자열을 printf로 출력하면 문자열에 대한
포인터 타입으로 변경해야 하기 때문에 cout을 사용하는게 편하다. 
*/ 
