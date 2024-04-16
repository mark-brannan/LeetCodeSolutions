class Solution {
    fun countPrimes(n: Int): Int {
        if (n <= 2) return 0

        val primes = BooleanArray(n) { true }
        primes[0] = false
        primes[1] = false

        for (i in 2..(n-1)) {
            if (primes[i]) {
                val iSquared = i.toDouble().pow(2).toInt()
                if (iSquared >= n) break
                for (j in iSquared..n step i) {
                    if (j >= n) { break }
                    else { primes[j] = false }
                }
            }
        }
        return primes.slice(2..(n-1)).count { it == true }
    }
}