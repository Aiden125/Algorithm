// https://leetcode.com/problems/path-sum-ii/
// 레퍼런스 https://www.youtube.com/watch?v=7yDOius2XSs
#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    // 전역변수 설정
    vector<vector<int>> v;
    vector<int> path;
    
    void dfs(TreeNode* root, int sum) {
        if(!root) return;
        
        path.push_back(root->val);
        sum = sum - root->val; // 17 13 2 -5

        if(!root->left && !root->right && sum==0) {
            v.push_back(path);
        }

        dfs(root->left, sum);
        dfs(root->right, sum);
        path.pop_back();
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        dfs(root, sum);
        return v;
    }
};