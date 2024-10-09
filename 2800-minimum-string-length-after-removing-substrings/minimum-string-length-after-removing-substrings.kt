class Solution {
    fun minLength(s: String): Int {
        var string = s

        while (string.contains("AB") || string.contains("CD")) {
            string = string.replace(Regex("AB|CD"), "")
        }

        return string.length
    }
}