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
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val queue = ArrayDeque<Pair<Int, TreeNode>>()
        val columnTable = mutableMapOf<Int, MutableList<Int>>()

        if (root == null) return listOf()
        queue.add(0 to root!!)
        while (queue.isNotEmpty()) {
            val (column, node) = queue.removeLast()
            System.out.println("Column $column node: ${node?.`val`}")
            columnTable.getOrPut(column) { mutableListOf() }.add(node.`val`)

            if (node.left != null) {
                queue.addFirst(column - 1 to node.left)
            }
            if (node.right != null) {
                queue.addFirst(column + 1 to node.right)
            }

            System.out.println("$columnTable")
        }
        return columnTable
            .toSortedMap()
            .mapValues { it.value as List<Int> }
            .values.toList()
    }
}