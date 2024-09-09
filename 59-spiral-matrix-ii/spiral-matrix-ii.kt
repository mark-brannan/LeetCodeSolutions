class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }
        var (top, bottom) = 0 to n - 1
        var (left, right) = 0 to n - 1

        var x = 1
        while (x <= n * n) {
            // top row
            for (j in left..right) {
                matrix[top][j] = x++
            }
            ++top

            // right column
            for (i in top..bottom) {
                matrix[i][right] = x++
            }
            --right

            if (top <= bottom) {
                // bottom row
                for (i in right downTo left) {
                    matrix[bottom][i] = x++
                }
                --bottom
            }

            if (left <= right) {
                // left column
                for (j in bottom downTo top) {
                    matrix[j][left] = x++
                }
                ++left
            }
        }
        return matrix
    }
}