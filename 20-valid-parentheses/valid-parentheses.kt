class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '(', '{', '[' -> stack.add(c)
                ')', '}', ']' -> {
                    if (stack.isEmpty()) return false
                    val prior = stack.removeLast()
                    if (isMismatched(c, prior)) return false
                }
            }
        }
        return stack.isEmpty()
    }

    private fun isMismatched (new: Char, prior: Char) = !matches(new, prior)

    private fun matches(new: Char, prior: Char): Boolean {
        return when (prior) {
            '(' -> new == ')'
            '{' -> new == '}'
            '[' -> new == ']'
            else -> false
        }
        .also { System.out.println("$new, $prior: $it")}
    }
}