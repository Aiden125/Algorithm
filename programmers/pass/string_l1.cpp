/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=cpp
 * 폰켓몬 문제
*/
#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    map<int, int> mp;
    
    for(int i=0; i<nums.size(); i++){ // map는 오름차순 정렬
        mp[nums[i]]++;
    }
    
    int mpSize = mp.size();
    int numsSize = nums.size()/2;
    answer = min(mpSize, numsSize);
    
    return answer;
}