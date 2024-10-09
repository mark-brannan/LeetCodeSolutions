class Solution {
    fun getLucky(s: String, k: Int): Int {
        var output = s.firstTransform()
        for (i in 2..k) {
            output = output.secondaryTransform()
        }
        return output
    }

    val Char.positionInAlphabet: Int
        get() = this.code - 96

    fun String.firstTransform() = this.toCharArray()
        .map { it.positionInAlphabet }
        .map(Int::toString)
        .joinToString("")
        .map { it.digitToInt() }
        .sum()

    fun Int.secondaryTransform() = this.toString()
        .toCharArray()
        .map { it.digitToInt() }
        .sum()
}