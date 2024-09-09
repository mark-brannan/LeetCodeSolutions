class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val (m, n) = matrix.size to matrix[0].size
        var (top, bottom) = 0 to m - 1
        var (left, right) = 0 to n - 1

        val output = mutableListOf<Int>()
        while (top <= bottom && left <= right) {
            // do top row
            for (i in left..right) {
                output.add(matrix[top][i])
            }
            ++top

            // do right column
            for (j in top..bottom) {
                output.add(matrix[j][right])
            }
            --right

            if (top <= bottom) {
                // do bottom row
                for (i in right downTo left) {
                    output.add(matrix[bottom][i])
                }
                --bottom
            }

            if (left <= right) {
                // do left column
                for (j in bottom downTo top) {
                    output.add(matrix[j][left])
                }
                ++left
            }
        }
        return output
    }
}