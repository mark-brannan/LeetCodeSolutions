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
    fun hasCycle(head: ListNode?): Boolean {
        var (fast, slow) = head to head
        while (true) {
            slow = slow?.next
            fast = fast?.next?.next
            when {
                slow == null || fast == null -> return false
                slow == fast -> return true
            }
        }
    }
}