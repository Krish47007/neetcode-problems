# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def dfs(self,root,depth,res):
        if not root:
            return
        #If the list at the current depth doesn't exist
        if len(res) == depth:
            res.append([]) #Create a new list for that depth
        #Nodes in the same depth will be added in the list of same depth
        res[depth].append(root.val)
        #Call for left and right subtrees
        self.dfs(root.left,depth + 1,res)
        self.dfs(root.right,depth + 1,res)

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        self.dfs(root,0,res)
        return res