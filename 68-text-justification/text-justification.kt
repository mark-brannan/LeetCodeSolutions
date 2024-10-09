class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        var line = 0
        val output = mutableListOf<String>()
        for ((i, word) in words.withIndex()) {

            if (output.lastIndex < line) {
                output.add(word)

            } else if ((output[line] + " " + word).length <= maxWidth) {
                output[line] += " " + word
            } else {
                // pad the current line
                output[line] = pad(output[line], maxWidth)

                // start a new line
                ++line
                output.add(word)
            }
        } 
        // keep last line left-justified, padding only the end
        output[line] = output[line].padEnd(maxWidth)

        return output
    }

    internal fun pad(string: String, maxWidth: Int): String {
        val words = string.split(" ").toMutableList()
        var extraPadding = maxWidth - string.length
        var i = 0
        while (extraPadding > 0) {
            words[i] = words[i] + " "
            --extraPadding
            i = if (i < words.lastIndex - 1) i + 1 else 0
        }
        return words.joinToString(" ")
    }
}