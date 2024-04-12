class Solution {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var i = 0
        var j = 0
        while (i < word.length && j < abbr.length) {
            when {
                word[i] == abbr[j] -> {
                    ++i
                    ++j
                }

                abbr[j].isDigit() -> {
                    val digits = abbr.slice(j..abbr.lastIndex).takeWhile { it.isDigit() }
                    if (digits.startsWith("0")) return false
                    val num = digits.toInt()
                    i += num
                    j += digits.length
                }

                else -> return false
            }
        }
        if (i == word.length && j == abbr.length) return true
        else return false
    }
}
/*
        var remainder = word
        abbr.parseAbbr().forEach {
            // println("Checking '$it' against '$remainder'...")
            remainder = when {
                remainder.startsWith(it) -> remainder.removePrefix(it)
                it.isNumeric() -> remainder.drop(it.toInt())
                else -> return false
            }
            // println("new remainder: '$remainder'")
        }
        return remainder.isEmpty()
    }

    private fun String.parseAbbr(): List<String> {
        val abbrList: MutableList<String> = mutableListOf()
        var remainder: String = this
        while (remainder.isNotBlank()) {
            val (right, left) = remainder.splitAbbreviation()
            abbrList.add(right)
            remainder = left
        }
        return abbrList
    }

    private fun String.splitAbbreviation(): Pair<String, String> {
        val letters = this.takeWhile { it.isLetter() }
        val digits = this.takeWhile { it.isDigit() }
        val abbr = letters.ifBlank { digits }.ifBlank { "" }
        return Pair(abbr, this.removePrefix(abbr))
    }

    private fun String.isNumeric() = this.all { it.isDigit() }
}
*/