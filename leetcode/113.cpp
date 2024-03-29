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
    //전역변수
    vector<int> path;
    vector<vector<int>> v;

    void dfs(TreeNode* root, int targetSum) {
        if(root == nullptr) return;

        path.push_back(root->val);
        targetSum = targetSum - root->val;

        if(root->left == nullptr && root->right == nullptr && targetSum==0) {
            v.push_back(path);
        }

        if(root->left != nullptr){
            dfs(root->left, targetSum);
            path.pop_back();
        }
        if(root->right != nullptr){
            dfs(root->right, targetSum);
            path.pop_back();
        }
        
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        dfs(root, targetSum);

        return v;
    }
};