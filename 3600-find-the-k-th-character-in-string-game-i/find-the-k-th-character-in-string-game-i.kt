class Solution {
    fun kthCharacter(k: Int): Char {
        var word = "a"
        while (word.length <= k) {
            val newWord = word.map { it.getNextChar() }.joinToString("")
            //System.out.println("$word -> $newWord -> ${word + newWord}")
            word = word + newWord
        }
        // kth in problem is using 1-based index, so access k - 1
        return word[k - 1]
        
    }

    fun Char.getNextChar() = when {
        this in 'a'..'y' -> this + 1
        this == 'z' -> 'a'
        else -> this + 1
    }
}