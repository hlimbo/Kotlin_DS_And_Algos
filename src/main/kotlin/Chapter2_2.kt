class Chapter2_2 {
    fun isPalindrome(word: String) : Boolean {
        var beginIndex = 0
        var endIndex = word.length - 1
        while(beginIndex < word.length / 2) {
            val leftChar = word[beginIndex]
            val rightChar = word[endIndex]

            if(leftChar != rightChar)
                return false

            beginIndex += 1
            endIndex -= 1
        }

        if(word.isEmpty())
            return false

        return true
    }

    //O(n * n * m) time solution where n is the size of the array and m is the size of the combined words
    fun generatePalindromePairs(list: ArrayList<String>) : ArrayList<Pair<Int, Int>> {
        val answer = ArrayList<Pair<Int,Int>>()

        for(i in 0 until list.size) {
            for(j in 0 until list.size) {
                if(i == j) continue

                val combinedWords: String = list[i] + list[j]
                if(isPalindrome(combinedWords)) {
                    answer.add(Pair(i, j))
                }
            }
        }

        return answer
    }
}