/**
java
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<List<Integer>> ret;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ret = new ArrayList<>();
        helper(root, 0);
        return ret;
    }
    public void helper(TreeNode node, int depth) {
        if(node==null) return;
        if(ret.size()<=depth) ret.add(new ArrayList<Integer>());
        ret.get(depth).add(node.val);
        helper(node.left, depth+1);
        helper(node.right, depth+1);
        return;
    }
}