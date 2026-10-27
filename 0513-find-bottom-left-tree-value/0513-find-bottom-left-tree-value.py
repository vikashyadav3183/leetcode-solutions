# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findBottomLeftValue(self, root):

        q = [root]
        ans = 0

        while q:

            size = len(q)

            for i in range(size):

                curr = q.pop(0)

                # First node of each level
                if i == 0:
                    ans = curr.val

                if curr.left:
                    q.append(curr.left)

                if curr.right:
                    q.append(curr.right)

        return ans