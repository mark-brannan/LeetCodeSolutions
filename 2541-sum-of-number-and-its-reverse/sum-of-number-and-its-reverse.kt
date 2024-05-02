class Solution {
    fun sumOfNumberAndReverse(num: Int): Boolean {
        for (i in 0..num) {
            if (i + i.reverseDigits() == num) {
                return true
            }
        }
        return false
    }

    private fun Int.reverseDigits() = this.toString().reversed().toInt()

}