#include <bits/stdc++.h>
using namespace std;

int target;
vector<int> nums;
int T;
int expected;
int output;
int searchInsert(vector<int>& nums, int target) {
    int low=0;
    int high=nums.size()-1; // 인덱스 기준이라 -1
    int mid = 0;

    while(low<=high){
        mid = (low + high)/2;

        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid] < target){
            low = mid + 1;
        }
        else if(nums[mid] > target){
            high = mid - 1;
        }
    }
    return low; // 인덱스 기준이기에

}

int main(){
    
    // // case 1
    nums = {1, 3, 5, 6};
    target = 5;
    expected = 2;

    output = searchInsert(nums, target);
    if(output == expected) cout << "accept" << "\n";

    // case 2
    nums = {1, 3, 5, 6};
    target = 2;
    expected = 1;

    output = searchInsert(nums, target);
    if(output == expected) cout << "accept" << "\n";
    
    // case 3
    nums = {1, 3, 5, 6, 8, 10};
    target = 11;
    expected = 6;

    output = searchInsert(nums, target);
    if(output == expected) cout << "accept" << "\n";

    // case 4
    nums = {1, 2, 3, 4, 5};
    target = 6;
    expected = 5;

    output = searchInsert(nums, target);
    if(output == expected) cout << "accept" << "\n";
    
    // case 5
    nums = {1, 3, 5, 6};
    target = 0;
    expected = 0;

    output = searchInsert(nums, target);
    if(output == expected) cout << "accept" << "\n";

    return 0;
}

/*
배열의 사이즈를 2로 나눠서 접근 target이 그거랑 같은지
다르다면? 접근값이 큰지, target이 큰지 비교
접근값이 크면 오른쪽으로, 작으면 왼쪽으로

low와 high값이 같아졌다면 출력

*/