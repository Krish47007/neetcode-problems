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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode curr = root;
        TreeNode ans = null;

        while(curr != null)
        {
            //Go right
            if(curr.val < p.val && curr.val < q.val)
                curr = curr.right;
            else if(curr.val > p.val && curr.val > q.val)
                curr = curr.left; //go left
            else
            {
                //curr lies inbetween and after that path diverges
                // as p lies in one side and q lies in the other side
                ans = curr;
                break;
            }
        }

        return ans;
    }
}
