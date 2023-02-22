class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        
        // root가 비어있다면 바로 리턴
        if(root==nullptr) {return {};}

        // queue, 벡터 생성
        queue <TreeNode*> q;
        vector<vector<int>> ans;
        
        q.push(root);
        while(!q.empty()){ // q가 비어있지 않다면
            int sz= q.size(); // q.size를 sz로
            vector<int> res; // ret 생성
            for(int i=0;i<sz;i++){ // sz사이즈만큼 돌려
                TreeNode* temp = q.front(); // temp = q.front
                res.push_back(temp->val);
                q.pop();
                if(temp->left ) q.push(temp->left);
                if(temp->right) q.push(temp->right);
            }
            ans.push_back(res);
        }
        return ans;
    }
};