// https://leetcode.com/problems/path-sum-ii/
// 레퍼런스 https://makga.tistory.com/73
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

    void checkNode(TreeNode* node, int targetSum, vector<vector<int>> vvec, vector<int> vec) {
        // node가 null리터럴이면(==node가 null이면)
        if (node == nullptr) {
            return;
        }

        // 1차원 벡터에 현재 value 담아주기
        vec.push_back(node->val); // [5, 4, 11, 2]
        
        // 1.leaf체크, 2.val이 targetSum이랑 같은지
        if (node->left == nullptr && node->right == nullptr) { // 리프노드라면
            if (node->val == targetSum) { // 리프노드 자체가 타겟썸이랑 같으면
                vvec.push_back(vec);
            }
            return;
        }

        if (node->left != nullptr) { // 4 11
            checkNode(node->left, targetSum - node->val, vvec, vec);
            // 리프노드에서 push된 데이터 제거
            vec.pop_back();
        }

        if (node->right != nullptr) { // 2
            checkNode(node->right, targetSum - node->val, vvec, vec);
            // 리프노드에서 push된 데이터 제거
            vec.pop_back();
        }
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> vvec; // 정답을 담을 2차원 벡터
        vector<int> vec; // 1차원 벡터
        checkNode(root, targetSum, vvec, vec);
        return vvec;
    }
};