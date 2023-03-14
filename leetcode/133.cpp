// https://leetcode.com/problems/path-sum-ii/
#incldue <bits/stdc++.h>
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
    void dfs(TreeNode* node, int targetSum, vector<vector<int>> vvec, vector<int> vec) {
        if(node == nullptr) {
            return;
        }    

        vec.push_back(node->val);

        if (node->left == nullptr && node->right == nullptr) {
            if(node->val == targetSum) {
                vvec.push_back(node);
            }
            return;
        }

        if(node->left != nullptr) {
            dfs(node, targetSum - node->left, vvec, vec);
            vec.pop_back();
        }

        if(node->right != nullptr) {
            dfs(node, targetSum-node->right, vvec, vec);
            vec.pop_back();
        }
    }


    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> vvec; // answer
        vector<int> vec;
        dfs(root, targetSum, vvec, vec);
        return vvec;
    }
};