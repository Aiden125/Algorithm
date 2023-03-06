class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        map<char, int> mp;

        // 1. map 받고 가장 긴 값 표시
        int maxValue = 0;
        for(int i=0; i<tasks.size(); i++) {
            mp[tasks[i]]++;
            maxValue = max(maxValue, mp[tasks[i]]);
        }

        // 2. 결국 maxValue와 n의 휴지시간 만큼 길이가 되어야하므로
        int idleLength = (maxValue - 1) * n;


        // 3. map 순회하면서
        for(auto it : mp) {
            idleLength -= min(maxValue - 1, it.second);
        }
        idleLength += maxValue - 1;

        return tasks.size() + max(0, idleLength);
        
    }
};