class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = mutableSetOf<Pair<Int, Int>>()

        fun dfs(x: Int, y: Int) {
            when {
                x < 0 || y < 0
                    || x > grid.lastIndex
                    || y > grid[0].lastIndex
                    || grid[x][y] == '0' -> return
                Pair(x, y) in visited -> return
            }
            // x,y then guaranteed to be land
            visited.add(x to y)
            dfs(x + 1, y)
            dfs(x - 1, y)
            dfs(x, y + 1)
            dfs(x, y - 1)
        }

        var islandCount = 0
        for (x in grid.indices) {
            for (y in grid[0].indices) {
                if (grid[x][y] == '1' && (x to y) !in visited) {
                    islandCount += 1
                    dfs(x, y)
                }
            }
        }
        return islandCount
    }
}