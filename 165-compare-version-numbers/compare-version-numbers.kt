class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split('.').map { it.toInt() }
        val v2 = version2.split('.').map { it.toInt() }
        val maxRevisions = maxOf(v1.size, v2.size)
        for (i in 0..maxRevisions) {
            val r1 = v1.getOrElse(i) { 0 }
            val r2 = v2.getOrElse(i) { 0 }
            when {
                r1 < r2 -> return -1
                r1 > r2 -> return 1
            }
        }
        return 0
    }
}