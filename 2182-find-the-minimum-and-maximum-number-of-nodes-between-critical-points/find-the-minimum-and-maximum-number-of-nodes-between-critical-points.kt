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
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        val output = intArrayOf(100000, -1)
        var position = 0
        val criticalPoints = ArrayDeque<Int>()

        var (prev, next, curr) = arrayOf<ListNode?>(null, null, head)
        while (curr != null) {
            next = curr?.next
            if (prev != null && next != null) {
                when {
                    curr.`val` < prev.`val` && curr.`val` < next.`val` -> criticalPoints.add(position)
                    curr.`val` > prev.`val` && curr.`val` > next.`val` -> criticalPoints.add(position)
                }

                with (criticalPoints) {
                    if (lastIndex >= 1) {
                        val potentialNewMin = this[lastIndex] - this[lastIndex - 1]
                        output[0] = minOf(potentialNewMin, output[0])
                        output[1] = last() - first()
                    }
                }
            }
            ++position
            prev = curr
            curr = next
        }

        if (output[1] == -1) output[0] = -1

        return output
    }
}