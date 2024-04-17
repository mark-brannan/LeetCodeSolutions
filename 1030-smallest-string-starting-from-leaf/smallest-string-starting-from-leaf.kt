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
    fun smallestFromLeaf(root: TreeNode?): String {
        if (root == null) return ""

        var smallest = Char.MAX_VALUE + ""
        val stack = ArrayDeque<Pair<TreeNode, String>>()

        stack.push(root to "")
        while (stack.isNotEmpty()) {
            val (next, priorString) = stack.pop()
            val newString = next.toChar() + priorString

            if (next.isLeaf()) {
                smallest = minOf(smallest, newString)
            }

            next.left?.let { stack.push(it to newString) }
            next.right?.let { stack.push(it to newString) }
        }
        return smallest
    }

    // ASCII 97 is 'a'
    internal fun TreeNode.toChar() = (this.`val` + 97).toChar()
}

fun TreeNode.isLeaf() = (left == null && right == null)
fun <T> ArrayDeque<T>.push(it: T) = this.add(it)
fun <T> ArrayDeque<T>.pop() = this.removeLast()
