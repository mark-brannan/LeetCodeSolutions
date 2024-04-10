class Solution {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var ticks = 0
        var i = 0
        while (tickets[k] > 0) {
            when {
                // no time taken, just ignoring people who have 'left' the line
                tickets[i] == 0 -> ++i
                // buy 1 ticket, tick the clock one second, go to next in line
                tickets[i] > 0 -> {
                    --tickets[i]
                    ++ticks
                    ++i
                }
            }
            if (i >= tickets.size) {
                i = 0
            }
        }
        return ticks
    }
}