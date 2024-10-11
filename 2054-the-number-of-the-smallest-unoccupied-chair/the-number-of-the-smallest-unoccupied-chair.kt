class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val targetCopy = times[targetFriend].copyOf()
        times.sortWith(compareBy { it[0] })

        val chairs = IntArray(times.size) { 0 }
        for (timePair in times) {
            val arrivalTime = timePair[0]
            val leavingTime = timePair[1]
            // find the first free chair and records the leavingTime
            for ((i, occupiedUntil) in chairs.withIndex()) {
                if (occupiedUntil <= arrivalTime) {
                    chairs[i] = leavingTime

                    // return the chair number if this is the target friend
                    if ((timePair).contentEquals(targetCopy)) {
                        return i
                    }
                    break
                }
            }
        }
        return -1
    }
}