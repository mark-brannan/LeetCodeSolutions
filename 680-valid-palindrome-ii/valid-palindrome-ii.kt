class Solution {
    fun validPalindrome(s: String): Boolean {
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            if (s[i] == s[j]) {
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
        if (length == 1) return true
        var i = 0
        var j = this.lastIndex
        while (i < j) {
            if (this[i] == this[j]) {
                ++i
                --j
            } else {
                return false
            }
        }
        return true

    }
}