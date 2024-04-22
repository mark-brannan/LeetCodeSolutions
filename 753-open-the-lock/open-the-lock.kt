internal fun <T> ArrayDeque<T>.enqueue(it: T) = this.add(it)
internal fun <T> ArrayDeque<T>.dequeue() = removeFirst()

class Solution {
    val startingState = "0000"
    
    fun openLock(deadends: Array<String>, target: String): Int {
        val visited = mutableSetOf<String>()
        val queue = ArrayDeque<Pair<Int, String>>()

        if (target in deadends || startingState in deadends) return -1

        queue.enqueue(0 to startingState)
        while (queue.isNotEmpty()){
            val (counter, state) = queue.dequeue()

            if (state == target) {
                return counter
            }

            for (adjacent: String in state.getAdjacentStates()) {
                when (adjacent) {
                    in visited -> continue
                    in deadends -> continue
                }
                visited.add(adjacent)
                queue.enqueue(counter + 1 to adjacent)
            }
        }
        return -1
    }

    internal fun String.getAdjacentStates(): Set<String> {
        val adjacentStates = mutableSetOf<String>()
        for (i in 0..3) {
            val chars = this.get(i).getAdjacentChars()
            for (char in chars) {
                val builder = StringBuilder(this)
                builder.set(i, char)
                val adjacent = builder.toString()
                adjacentStates.add(adjacent)
            }
        }
        return adjacentStates
    }

    internal fun Char.getAdjacentChars() = when (this) {
        '0' -> listOf('9', '1')
        '9' -> listOf('8', '0')
        else -> listOf(this - 1, this + 1)
    }



}