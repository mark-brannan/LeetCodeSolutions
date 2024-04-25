// create a set for reachable and unreachable nodes
// add the root to reachable, add restricted to unreachable
// for each edge...
// if 
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

        var counter = 0
        val queue = ArrayDeque<Int>()
        val visited = mutableSetOf<Int>()

        queue.add(0)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            visited.add(node)
            ++counter

            for (e in neighbors.getValue(node)) {
                when (e) {
                    in restricted -> {}
                    in visited -> {}
                    else -> queue.add(e)
                }
            }
        }
        return counter
    }
}

/*
        val reachable = mutableSetOf<Int>()
       val unreachable = mutableSetOf<Int>() //?
 
        for (edge in edges) {
            val firstNode = edge[0]
            val secondNode = edge[1]
        }

        val firstEdge = edges[0]
        val queue = ArrayDeque<>()
        val visited = mutableSetOf<>()

        queue.enqueue()
        while (queue.isNotEmpty()) {
            val node = queue.dequeue()

            // for adj edges
        }
        return visited.size
    }
}*/