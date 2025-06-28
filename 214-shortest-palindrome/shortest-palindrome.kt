class Solution {
    fun shortestPalindrome(s: String): String {

        // naively, the worst case is the length + (length - 1)
        // size 1 strings are trivially already a palindrome
        val worstCasePrefixLength = maxOf(1, s.length - 1)
        val prefix = CharArray(worstCasePrefixLength)
        var i = 0
        var j = s.lastIndex

        // start with the input string itself, consider prepending
        // an empty prefix string.  Then, adding characters from
        // the end of the string, one at a time, consider
        // prepending each new set of prefix characters

        while (isPalindrome(i - 1, prefix, s) == false) {
            prefix[i] = s[j]
            ++i
            --j
        }

        return prefix.concatToString(0, i) + s
    }
}

fun isPalindrome(i: Int, prefix: CharArray, s: String): Boolean {
    // System.out.println("Checking isPalindrome(): ${prefix.concatToString(0, maxOf(0, i))} + $s, ${i}, ${s.lastIndex}")
    var (left, right) = 0 to s.lastIndex
    while (left < (right + (i + 1))) {
        val leftChar = when {
            left > i -> {
                val leftShifted = left - (i + 1) // 0 when left=0, i=-1, 0 when left=1, i=0, 1 when left=1, i=-1
                //System.out.println("$left > $i -> ${s[leftShifted]}")
                s[leftShifted]
            }
            else -> {
                //System.out.println("prefix[$left]=${prefix[left]}")
                prefix[left]
            }
        }
        val rightChar = s[right]
        //System.out.println("$left, $right: $leftChar vs $rightChar (${i})")
        if (leftChar != rightChar) return false
        ++left 
        --right
    }
    return true
        //.also { System.out.println("isPalindrome($catted) is $it") }
}


/*fun isPalindrome(prefix: CharArray, s: String): Boolean {
    System.out.println("Checking isPalindrome(): ${prefix.concatToString()} + $s")
    var (i, j) = 0 to s.length
    var (left, right) = 0 to (prefix.lastIndex + s.lastIndex)
    while (left < right) {
        val leftChar = when {
            left <= prefix.lastIndex -> prefix[left]
            else -> s[left - prefix.lastIndex]
        }
        val rightChar = s[right - prefix.lastIndex]
        System.out.println("$left, $right: $leftChar vs $rightChar...${left - prefix.lastIndex}, ${right - prefix.lastIndex}")
        if (leftChar != rightChar) return false
        ++left 
        --right
    }
    return true
        //.also { System.out.println("isPalindrome($catted) is $it") }
}*/

fun String.isPalindrome(): Boolean {
    if (length <= 1) return true

    for (i in 0..lastIndex) {
        val j = lastIndex - i
        when {
            this[i] == this[j] && i < j -> continue
            this[i] == this[j] && i >= j -> return true
            else -> break
        }
    }
    return false
}