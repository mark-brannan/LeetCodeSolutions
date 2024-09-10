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
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var prev = head
        var next = head?.next
        while (prev != null && next != null) {
            val divisor = findGreatestCommonDivisor(prev.`val`, next.`val`)
            val newNode = ListNode(divisor)
            newNode.next = next
            prev.next = newNode

            prev = next
            next = next.next
        }
        return head
    }

    private fun findGreatestCommonDivisor(a: Int, b: Int): Int {
        var num1 = a
        var num2 = b
        while (num2 != 0) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }
        return num1
    }
}