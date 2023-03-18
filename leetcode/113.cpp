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
    void dfs(TreeNode* node, int targetSum, vector<int> vec, vector<vector<int>> vvec) {
        
        // null인지 체크
        if (node == nullptr) {
            return;
        }
        
        vec.push_back(node->val); //value를 담아주자

        // 리프 노드 인지 체크 하고 썸
        if (node->left == nullptr && node->right == nullptr) {
            if (node->val == targetSum) {
                vvec.push_back(vec);
            }
            return;
        }

        // 왼쪽 노드 인지 체크
        if (node->left != nullptr) {
            targetSum -= node->val;
            dfs(node->left, targetSum, vec, vvec);
            vec.pop_back();
        }

        // 오른쪽 노드 인지 체크
        if (node->right != nullptr) {
            targetSum -= node->val;
            dfs(node->right, targetSum, vec, vvec);
            vec.pop_back();
        }
        
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        // 한번 계산할 벡터, 답변용 벡터, dfs
        vector<int> vec; // 해당 노드 sum 구할 배열
        vector<vector<int>> vvec; // 답변 배열
        dfs(root, targetSum, vec, vvec);

        return vvec;
    }
};