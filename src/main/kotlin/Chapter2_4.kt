class Chapter2_4 {
    // assumption: k < str length
    // assumption: all characters are in lowercase........ if lexicographic order means alphabetic order
    fun rotateString(str: String,k: Int) : String {
        val stringBuilder = StringBuilder(str)
        for(i in 0 until k) {
            val temp = stringBuilder[i]
            for(j in 1 until str.length) {
                stringBuilder[j - 1] = stringBuilder[j]
            }
            stringBuilder[str.length - 1] = temp
        }
        return stringBuilder.toString()
    }

    fun uniquePermutations(originalStr: String,k: Int) : ArrayList<String> {
        val result = ArrayList<String>()

        // count original string as a possible permutation
        var intermediateString = originalStr
        for(i in 0 until originalStr.length) {
            intermediateString = rotateString(intermediateString, k)
            result.add(intermediateString)
        }

        return result
    }

    // doesn't solve the problem :( as I misunderstood the requirement of being able to move ONE of the first k letters to the end of the string
    // maintains relative order of the string (that is the character to the left and right of selected character will always stay the same)
    // goal: return the string that best matches lexicographic order
    fun determineLexicographicRotatedString(originalStr: String,k: Int) : String {

        val uniques: ArrayList<String> = uniquePermutations(originalStr, k)

        // comparison strategy
        // per each character pair in comparison, favor the character
        // that comes earlier in the alphabet starting from the leftmost character
        // if both characters are equal, compare against the next pair of characters
        var answer = originalStr
        for(unique in uniques) {
            for(i in 0 until answer.length) {
                if(answer[i] > unique[i]) {
                    answer = unique
                    break
                } else if(answer[i] < unique[i]) {
                    break
                }
            }
        }

        return answer
    }
}