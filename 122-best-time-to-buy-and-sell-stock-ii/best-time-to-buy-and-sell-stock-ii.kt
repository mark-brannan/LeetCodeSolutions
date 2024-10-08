class Solution {
    fun maxProfit(prices: IntArray): Int {
        return prices.asList().zipWithNext { a,b -> max(b - a, 0) }.sum()
    }
}