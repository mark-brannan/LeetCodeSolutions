class Solution {
    fun removeOccurrences(s: String, part: String): String {
        var sPrime = s
        while (sPrime.contains(part)) {
            sPrime = sPrime.replaceFirst(part, "")
        }
        return sPrime
    }
}