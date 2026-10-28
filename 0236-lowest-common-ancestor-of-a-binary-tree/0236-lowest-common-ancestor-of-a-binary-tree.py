# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None   
class Solution:
    def lowestCommonAncestor(self, root, p, q):

        # Base condition
        if root is None or root == p or root == q:
            return root

        # Search left subtree
        left = self.lowestCommonAncestor(root.left, p, q)

        # Search right subtree
        right = self.lowestCommonAncestor(root.right, p, q)

        # Both nodes found in different subtrees
        if left and right:
            return root

        # Return the side where node was found
        return left if left else right