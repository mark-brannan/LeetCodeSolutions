class Solution {
    fun destCity(paths: List<List<String>>): String {
        val map = paths.associateBy( {it.get(0)}, {it.get(1)} )
        val destinationsWithNoOrigin = map.values - map.keys
        return destinationsWithNoOrigin.first()
    }
}