// https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java
#include <bits/stdc++.h>
using namespace std;
/**
1. k만큼 자르기 전에 가장 큰 수를 일단 찾아야한다.
2. k 만큼 실제로 잘라주고 그래도 k가 남으면 더 자를것들을 안에서 찾는다.
*/

string solution(string number, int k)
{
	string answer = "";
    int idx = -1;
	for (int i=0; i<number.length()-k; i++) 
	{
		char max = 0;
		for (int j=idx + 1; j<=k+i; j++) 
		{
			if (max < number[j]) 
			{
				idx = j;
				max = number[j];
			}
		}
		answer += max;
	}
	return answer;
}

int main() {
    string number;
    int k;
    
    // test1
    number = "1924";
    k = 2;
    cout << solution(number, k) << "\n";

    // test2
    number = "1231234";
    k = 3;
    cout << solution(number, k) << "\n";

    // test3
    number = "4177252841";
    k = 4;
    cout << solution(number, k) << "\n";

    return 0;
}



