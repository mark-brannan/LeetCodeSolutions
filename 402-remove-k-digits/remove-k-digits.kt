class Solution {
    fun removeKdigits(num: String, k: Int): String {
        var k = k
        val stack = ArrayDeque<Char>()
        num.forEach {
            while (k > 0 && stack.isNotEmpty() && stack.last() > it) {
                stack.removeLast()
                --k
            }
            stack.add(it)
        }
        while (stack.isNotEmpty() && k > 0) {
            stack.removeLast()
            --k
        }

        val result = stack.joinToString("").trimStart('0')
        return if (result.isNotEmpty()) result else "0"
        
    }
}