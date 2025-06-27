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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var headPair = Pair(list1, list2)
        var current = dummy

        while (current != null) {
            with (headPair.orderNodes()) {
                current.next = first
                headPair = Pair(first?.next, second)
                current = current.next
            }
        }
        return dummy.next
    }
}

fun Pair<ListNode?, ListNode?>.orderNodes(): Pair<ListNode?, ListNode?> {
    return when {
     first == null -> second to first
     second == null -> first to second
     first!!.`val` < second!!.`val` -> first to second
     else -> second to first
    }
}
