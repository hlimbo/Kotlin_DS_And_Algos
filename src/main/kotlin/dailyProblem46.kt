fun isPalindrome(str: String) : Boolean {
    var i = 0
    var j = str.length - 1
    while(i < str.length) {
        if(str[i] != str[j])
            return false
        ++i
        --j
    }

    return true
}

fun dailyProblem46(str: String) : String {

    // gather a list of all possible substrings within str
    val subStrs = ArrayList<String>()
    for(i in 0 until str.length) {
        var j = i
        while(j < str.length) {
            val subString = str.substring(i,j + 1)
            subStrs.add(subString)
            ++j
        }
    }

    // identify all substrings in current collection that are palindromes
    // and move them into a separate list
    val palindromes = ArrayList<String>()
    for(subString in subStrs) {
        if(isPalindrome(subString)) {
            palindromes.add(subString)
        }
    }

    // find the palindrome with the max character length and return it as the answer
    var maxPalindrome = ""
    for(palindrome in palindromes) {
        if(maxPalindrome.length < palindrome.length) {
            maxPalindrome = palindrome
        }
    }

    return maxPalindrome
}