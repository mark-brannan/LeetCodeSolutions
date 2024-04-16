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
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {

        if (depth == 1) {
            val node = TreeNode(`val`)
            node.left = root
            return node
        }
        
        val queue = ArrayDeque<Pair<TreeNode, Int>>()

        root?.let { queue.add(it to 1) }
        while (queue.isNotEmpty()) {
            val (node, currentDepth) = queue.removeFirst()
            when (currentDepth) {
                (depth - 1) -> node.insertValue(`val`)
                depth -> break
            }
            node.left?.let { queue.add(it to currentDepth + 1) }
            node.right?.let { queue.add(it to currentDepth + 1) }
        }
        return root
    }

    fun TreeNode.insertValue(value: Int) {
        val left = this.left
        val right = this.right
        this.left = TreeNode(value)
        this.right = TreeNode(value)
        this.left.left = left
        this.right.right = right
    }
}