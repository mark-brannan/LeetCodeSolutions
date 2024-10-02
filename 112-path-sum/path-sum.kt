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
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        val stack = ArrayDeque<Pair<TreeNode?, Int>>()

        stack.add(root to 0)
        while (stack.isNotEmpty()) {
            val (node, sum) = stack.removeLast()
            if (node != null) {
                val newSum = sum + node.`val`

                if (node.isLeaf()) {
                    if ( newSum == targetSum) return true
                }
                stack.add(node?.left to newSum)
                stack.add(node?.right to newSum)
            }
        }
        return false
    }

    internal fun TreeNode.isLeaf() = (this.left == null && this.right == null)

}