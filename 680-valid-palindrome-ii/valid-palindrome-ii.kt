class Solution {
    fun validPalindrome(s: String): Boolean {
        if (s.length == 1) return true

        val chars = s.toCharArray()
        var i = 0
        var j = chars.lastIndex
        while (i < j) {
            if (chars[i] == chars[j]) {
                ++i
                --j
            } else {
                val slice1 = s.slice((i+1)..j)
                val slice2 = s.slice(i..(j-1))
                return slice1.isPalindrome() || slice2.isPalindrome()
            }
        }
        return true
    }

    fun String.isPalindrome(): Boolean {
        return this == this.reversed()
    }
}