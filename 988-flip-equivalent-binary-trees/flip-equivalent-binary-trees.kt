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
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        val queue1 = ArrayDeque<TreeNode?>()
        val queue2 = ArrayDeque<TreeNode?>()
        // add nothing if either root is null
        root1?.let { queue1.add(it) }
        root2?.let { queue2.add(it) }

        while (queue1.isNotEmpty() && queue2.isNotEmpty()) {

            val node1 = queue1.removeFirst()
            val node2 = queue2.removeFirst()
            if (node1?.`val` != node2?.`val`) {
                return false
            }

            node1?.smallestEdgeFirst()?.forEach { queue1.add(it) }
            node2?.smallestEdgeFirst()?.forEach { queue2.add(it) }
        }

        return queue1 == queue2
    }

    fun TreeNode.smallestEdgeFirst(): List<TreeNode?> {
        return listOf(left, right).sortedBy { it?.`val` }
    }
}