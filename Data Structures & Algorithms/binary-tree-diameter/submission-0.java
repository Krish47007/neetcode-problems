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

    private int diameter = 0;

    private int  rec(TreeNode root)
    {
        if( root == null)
            return 0;
        
        int lh = rec(root.left);
        int rh = rec(root.right);

        int height = Math.max(lh,rh);
        this.diameter = Math.max(diameter,height);
        this.diameter = Math.max(diameter,lh + rh);

        return 1 + height;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;
        rec(root);
        return this.diameter;
    }
}
