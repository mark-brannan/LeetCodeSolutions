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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val output = mutableListOf<List<Int>>()
        val stack = ArrayDeque<Pair<TreeNode?, Pair<Int, List<Int>>>>()

        stack.add(root to (0 to listOf())) 
        while (stack.isNotEmpty()) {
            val (node, priorData) = stack.removeLast()
            val (priorSum, priorValues) = priorData
            if (node != null) {
                val newSum = priorSum + node.`val`
                val newValuesList = priorValues + node.`val`

                if (node.isLeaf()) {
                    if (newSum == targetSum) {
                        output.add(newValuesList)
                    }
                } else {
                    stack.add(node?.left to (newSum to newValuesList))
                    stack.add(node?.right to (newSum to newValuesList))
                }
            }
        }
        return output
    }

    internal fun TreeNode.isLeaf() = (this.left == null && this.right == null)

}