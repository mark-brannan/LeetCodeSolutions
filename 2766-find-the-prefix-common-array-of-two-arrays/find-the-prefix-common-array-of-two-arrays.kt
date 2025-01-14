class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val C = IntArray(A.size)
        val set1 = mutableSetOf<Int>()
        val set2 = mutableSetOf<Int>()
        for (i in A.indices) {
            set1.add(A[i])
            set2.add(B[i])
            C[i] = (set1 intersect set2).size
        }
        return C
    }
}