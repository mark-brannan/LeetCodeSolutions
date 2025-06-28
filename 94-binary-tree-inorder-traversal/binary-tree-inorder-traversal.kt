/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val values = mutableListOf<Int>()
        if (root == null) return values
        val stack = ArrayDeque<TreeNode>()
        var node = root

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node)
                node = node.left
            } else {
                node = stack.removeLast()
                values.add(node.`val`)
                node = node.right
            }
        }
        return values
    }
}