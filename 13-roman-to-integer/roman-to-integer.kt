class Solution {
    fun romanToInt(s: String): Int {
        var value = 0
        val chars = s.toCharArray()
        var i = chars.lastIndex
        while (i >= 0) {
            if (i >= 1) {
                val twoCharString = "" + chars[i-1] + chars[i] 
                if (doubleCharMap.containsKey(twoCharString)) {
                    value += doubleCharMap.getValue(twoCharString)
                    i -= 2
                    continue
                }
            }
            value += singleCharMap.getValue(chars[i--])
        }
        return value
    }

    val singleCharMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    val doubleCharMap = mapOf(
        "IV" to 4,
        "IX" to 9,
        "XL" to 40,
        "XC" to 90,
        "CD" to 400,
        "CM" to 900
    )
}