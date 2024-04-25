class Solution {
    fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {

        val neighbors = mutableMapOf<Int, Set<Int>>()
        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            val aValues = setOf(b) + neighbors.getOrPut(a) { setOf(b) }
            val bValues = setOf(a) + neighbors.getOrPut(b) { setOf(a) }
            neighbors[a] = aValues
            neighbors[b] = bValues
        }
        //System.out.println("neighbors=$neighbors")

        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()

        queue.add(0)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            visited.add(node)

            for (e in neighbors.getValue(node)) {
                when (e) {
                    in restricted -> {}
                    in visited -> {}
                    else -> queue.add(e)
                }
            }
        }
        return visited.size
    }
}