class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        folder.sort()
        val output = folder.toMutableList()

        var i = 0
        while (i < output.lastIndex) {
            val current = output[i]
            output.removeAll {
                it.isSubFolderOf(current)
            }
            ++i
        }
        return output
    }

    fun String.isSubFolderOf(rhs: String): Boolean {
        return this.startsWith(rhs) && this.substringAfter(rhs).startsWith("/")
    }
}