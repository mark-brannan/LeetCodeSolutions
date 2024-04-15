class Solution {
    fun nthUglyNumber(n: Int): Int {
        val uglies = mutableListOf(1)
        var i2 = 0
        var i3 = 0
        var i5 = 0

        while (uglies.size < n) {
            while (uglies[i2]*2 <= uglies.last()) ++i2
            while (uglies[i3]*3 <= uglies.last()) ++i3
            while (uglies[i5]*5 <= uglies.last()) ++i5
            val k2 = uglies[i2] * 2
            val k3 = uglies[i3] * 3
            val k5 = uglies[i5] * 5
            uglies.add(minOf(k2, k3, k5))
            //System.out.println("${uglies.size} - added ${uglies.last()}(2:$i2 3:$i3 5:$i5) uglies=$uglies")
        }
        return uglies.last()
    }
}