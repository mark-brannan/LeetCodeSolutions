// [2,3,5,7,11,13,17]
// [2, ,3, ,5, ,7]
// [2, ,3, ,5, ,7]
// [2,13,3,11,5,17,7]
// 
// [2,3,5,7,11,13,17,23,41,65,93,101]
// [2,,3,,5,,7,,11,,13,,17,23,41,65,93,101]

class Solution {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        deck.sort()
        val queue = ArrayDeque<Int>(deck.indices.toList())
        val result = IntArray(deck.size)
        for (n in deck) {
            //System.out.println("queue=$queue")
            val i = queue.removeFirst()
            result[i] = n

            // If we have more, take the next and move it to end of the queue
            if (queue.isNotEmpty()) {
                queue.removeFirst().let { queue.add(it) }
            }
            //System.out.println("queue=$queue, result=${result.toList()}")
        }
        return result
    }
}