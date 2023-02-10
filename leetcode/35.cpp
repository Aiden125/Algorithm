class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int low=0;
        int high=nums.size();
        int mid = (low+high) / 2;

        while(true){
            if(nums[mid]==target){
                return mid;
            }
            if(low == high){
                return low;
            }

            if(nums[mid]>target){
                low = mid;
                mid = (low+high)/2;
            }else if(nums[mid]<target){
                high = mid;
                mid = (low+high)/2;
            }
        }

    }
};

/*
배열의 사이즈를 2로 나눠서 접근 target이 그거랑 같은지
다르다면? 접근값이 큰지, target이 큰지 비교
접근값이 크면 오른쪽으로, 작으면 왼쪽으로

low와 high값이 같아졌다면 출력

*/