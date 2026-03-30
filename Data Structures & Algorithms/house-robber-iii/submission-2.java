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

    private int rec(TreeNode root,Map<TreeNode,Integer> dp)
    {
        if(root == null)
            return 0;
        if(dp.containsKey(root))
            return dp.get(root);
        
        //Take flow
        int take = root.val;
        if(root.left != null)
        {
            take += rec(root.left.left,dp);
            take += rec(root.left.right,dp);
                
        }
        if(root.right != null)
        {
           take += rec(root.right.left,dp);
            take += rec(root.right.right,dp);
        }

        int skip = rec(root.left,dp) + rec(root.right,dp);
        int ans = Math.max(take,skip);

        dp.put(root,ans);

        return ans;
    }
    public int rob(TreeNode root) {
        
        Map<TreeNode,Integer> dp = new HashMap<>();
        return rec(root,dp);
    }
}