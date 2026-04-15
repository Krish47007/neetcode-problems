/**
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

    private void rec(TreeNode root,int depth,List<List<Integer>> ans)
    {
        if(root == null)
            return;
        
        if(ans.size() == depth)
        {
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(root.val);

        rec(root.left,depth + 1,ans);
        rec(root.right,depth + 1,ans);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(root,0,ans);
        return ans;
    }
}
