class Solution {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val pq = PriorityQueue<Pair<Int, Int>>(k, myComparator)
        for (j in arr.lastIndex downTo 0) {
            for (i in (j-1) downTo 0) {
                pq.add(arr[i] to arr[j])
                //System.out.println(pq.toArray().asList())
            }
        }
        repeat(k-1) { pq.poll() }
        val kthPair = pq.peek()
        return intArrayOf(kthPair.first, kthPair.second)
    }

    val myComparator: Comparator<Pair<Int, Int>> = compareBy({ it.first / it.second.toDouble() })

}