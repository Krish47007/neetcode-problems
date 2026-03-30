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

    private void rec(TreeNode curr,int depth,List<List<Integer>> res)
    {
        if(curr == null)
            return;
        
        //If no list exist for this depth
        //Create a new list
        if(res.size() == depth)
        {
            res.add(new ArrayList<>());
        }

        //Get the list corresponding to the list and the curr element
        res.get(depth).add(curr.val);
        //Call for left and right child and increment the depth
        rec(curr.left,depth + 1, res);
        rec(curr.right,depth + 1, res);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        rec(root,0,res);
        return res;
    }
}
