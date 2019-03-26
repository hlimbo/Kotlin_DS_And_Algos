
// TODO: implement o(n) time and space solution using hash maps
class Chapter2_1 {

    fun isAnagram(word: String, subStr: String) : Boolean {
        for(i in subStr) {
            if(!word.contains(i)) {
                return false
            }
        }
        return true
    }

    // o(n * n * m) solution where n is the length of s and m is the length of word
    fun findAnagramIndices2(word: String, s: String) : ArrayList<Int> {
        val startIndices = ArrayList<Int>()

        var index = 0
        while(index + word.length <= s.length) {
            val subStr = s.substring(index, index + word.length)
            if(isAnagram(word, subStr)) {
                startIndices.add(index)
            }
            index += 1
        }

        return startIndices
    }


    // O(n*m) solution where n is the length of s and m is the length of word
    fun findAnagramIndices(word: String, s: String) : ArrayList<Int> {
        val startIndices = ArrayList<Int>()
        var sharedCharLength = 0
        var charCounter = 0

        var index = 0
        while(index < s.length) {
            val sChar = s[index]

            if(word.contains(sChar)) {
                sharedCharLength += 1
            }
            if(sharedCharLength > 0) {
                charCounter += 1
            }

            if(sharedCharLength == word.length) {
                startIndices.add(index + 1 - word.length)
                sharedCharLength = 0
                charCounter = 0
                // take into account for anagrams that can overlap with other characters in the same string
                index -= 1
            } else if(charCounter >= word.length) {
                sharedCharLength = 0
                charCounter = 0
                // take into account for anagrams that can overlap with other characters in the same string
                index -= 1
            }

            index += 1
        }

        return startIndices
    }
}