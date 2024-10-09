class Solution {
    fun minAddToMakeValid(s: String): Int {

        var inserts = 0
        var opened = 0
        for (i in 0..s.lastIndex) {
            when (s[i]) {
                '(' -> ++opened
                ')' -> --opened
            }

            if (opened < 0) {
                ++inserts
                ++opened
            }
        }

        return inserts + opened
    }
}