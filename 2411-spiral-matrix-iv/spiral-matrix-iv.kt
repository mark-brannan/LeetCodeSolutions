/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val matrix = Array(m) { IntArray(n) { -1 } }
        var node = head
        var (i, j) = 0 to 0
        var direction = 0 to 1
        while (node != null) {
            matrix[i][j] = node.`val`
            node = node.next
            val iNext = i + direction.first
            val jNext = j + direction.second
            if (iNext !in 0..m-1 || jNext !in 0..n-1 || matrix[iNext][jNext] != -1 ) {
                direction = direction.rotated()
            }
            i = i + direction.first
            j = j + direction.second
        }
        return matrix
    }

    private fun Pair<Int, Int>.rotated() = this.second to -(this.first)
}