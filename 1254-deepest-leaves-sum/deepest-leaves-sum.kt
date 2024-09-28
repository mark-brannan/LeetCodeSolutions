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
    fun deepestLeavesSum(root: TreeNode?): Int {

        var level = 0
        var levelSum = 0
        val queue = ArrayDeque<TreeNode>()
        root?.let { queue.add(it) }
        while (queue.isNotEmpty()) {
            ++level
            levelSum = 0

            for (i in 0..queue.lastIndex) {
                val node = queue.removeFirst()
                levelSum += node.`val`
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }

        return levelSum
    }
}