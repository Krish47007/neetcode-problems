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

    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null)
            return root;
        //Check left subtree
        if(root.val > key)
            root.left = deleteNode(root.left,key);
        //Check right subtree
        else if(root.val < key)
            root.right = deleteNode(root.right,key);
        else
        {
            //If No left child
            if(root.left == null)
                return root.right;
            //If no right child
            if(root.right == null)
                return root.left;
                
            //Both children so replace with inorder successor
            TreeNode curr = root.right;
            //Get the inorder sucessor
            while(curr.left != null)
            {
                //Traverse left
                curr = curr.left;
            }

            //Replace root with curr.left's value
            root.val = curr.val;

            //Now delete curr.left
            root.right = deleteNode(root.right,curr.val);
        }

        return root;

    }
}