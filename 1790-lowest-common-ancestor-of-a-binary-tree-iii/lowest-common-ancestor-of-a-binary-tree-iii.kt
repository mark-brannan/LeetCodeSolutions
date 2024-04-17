/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *		var left: TreeNode? = null
 *		var right: TreeNode? = null
 *		var parent: Node? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        if (p == null || q == null) return null
        val pPath = p.getPathToRoot()
        val qPath = q.getPathToRoot()
        val common = qPath.intersect(pPath)
        return common.firstOrNull()
    }

    internal fun Node.getPathToRoot(): List<Node> {
        val path = mutableListOf<Node>()
        var next: Node? = this
        while (next != null) {
            path.add(next)
            next = next?.parent
        }
        return path
    }
}