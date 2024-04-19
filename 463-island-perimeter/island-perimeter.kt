class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        
        val visited = mutableSetOf<Pair<Int, Int>>()
        fun dfs(x: Int, y: Int): Int {
            when {
                x < 0 || y < 0
                    || x > grid.lastIndex
                    || y > grid[0].lastIndex
                    || grid[x][y] == 0 -> return 1
                Pair(x, y) in visited -> return 0
            }
            // x,y then guaranteed to be land
            visited.add(x to y)
            val perimeter = dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1)
            return perimeter
        }

        // find land to start
        for (x in grid.indices) {
            for (y in grid[0].indices) {
                if (grid[x][y] == 1) {
                    return dfs(x, y)
                }
            }
        }
        return 0
    }
}