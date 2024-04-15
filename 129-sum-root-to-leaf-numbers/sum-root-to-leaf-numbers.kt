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
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0

        var rootToLeafSums = 0
        val stack = ArrayDeque<Pair<TreeNode?, Int>>()

        stack.add(root to 0)
        while (stack.isNotEmpty()) {
            val (current, priorSum) = stack.removeLast()
            if (current != null) {
                val newSum = priorSum * 10 + current.`val`
                //System.out.println("current=${current.`val`}, newSum=$newSum")
                when {
                    current.isLeaf() -> rootToLeafSums += newSum .also {
                    //System.out.println("At leaf: increment by $newSum to get $rootToLeafSums")
                    }
                    else -> {
                        stack.add(current.right to newSum)
                        stack.add(current.left to newSum)
                    }
                }
            }
         }
         return rootToLeafSums
    }

    internal fun TreeNode.isLeaf() = (this.left == null && this.right == null)

}