import java.util.*

/*
This problem was asked by Facebook.

Implement regular expression matching with the following special characters:

    . (period) which matches any single character
    * (asterisk) which matches zero or more of the preceding element

 */

// combine regular expression characters together (.....) (a*b*c*d*e)
// special regular exp characters can be combined together to generate different meaning
    // .* match any single character that occurs zero OR more times
    // *. match zero or more of the preceding element AND ends with any SINGLE character
// write some logic that analyzes the string and counts the number of periods and asterisks
// strategy using a stack
// for each character in the string named regExp
// push the character in the stack
// if the character is a period


fun dailyProblem25(str : String, regExp : String) : Boolean {
    var answer : Boolean = true

    var strIndex = 0
    var prevRegExpIndex = -1
    var regExpIndex = 0
    while(regExpIndex < regExp.length && strIndex < str.length) {

        if(regExp[regExpIndex] == '*') {
            if(prevRegExpIndex != -1) {
                val prev : Char = regExp[prevRegExpIndex]
                if(prev == '.') {
                    --regExpIndex
                }
                else if(prev != str[strIndex]) {
                    answer = false
                    break
                }
                else {
                    --regExpIndex
                }
            } else {
                answer = false
                break
            }
        }
        else if(regExp[regExpIndex] != '.' && regExp[regExpIndex] != str[strIndex]) {
            answer = false
            break
        }

        prevRegExpIndex = regExpIndex
        ++regExpIndex
        ++strIndex
    }

    // this fix does not take into account for the fact that a string may contain special regex chars
    // in between the string
    if(prevRegExpIndex != -1 && regExp[prevRegExpIndex] == '.' && regExp != ".*" && str.length > regExp.length) {
        answer = false
    }

    if(str.isEmpty() && str != regExp) {
        answer = false
    }

    return answer
}

// strategy for this one would be to push each character into its respective stack
// when an asterisk is pushed onto the stack, pop it off so we can compare the most recent
// character in str against the previous character in regexp

// application of nondeterministic finite automata (RIP something I didn't get cover in my undergrad courses)
// should do my homework to learn about the Thompson Construction algorithm
// which is used to convert a regular expression into a Nondeterministic finite automata

// algorithm has no concept of looking ahead to see if string does not end with *
fun dailyProblem25Stack(str : String, regExp: String) : Boolean {
    var answer = true
    var regExpStack = Stack<Char>()

    var regExpIndex = 0
    var strIndex = 0
    var wasAsteriskEncountered : Boolean = (regExp.isNotEmpty() && regExp[0] == '*')
    var topChar : Char? = null
    var prevChar : Char? = null

    if(regExp.isNotEmpty()) {
        regExpStack.push(regExp[regExpIndex])
    }

    while(regExpStack.isNotEmpty()) {

        prevChar = if(regExpIndex != 0) topChar else null
        topChar = regExpStack.pop()

        if(topChar == '*') {
            wasAsteriskEncountered = true
        }

        if(wasAsteriskEncountered) {
            // assumption: zero or more of the preceding character that is nothing will always evaluate to false
            if(prevChar == null) {
                answer = false
                break
            }

            // if preceding element in the pattern DOES NOT current element in str
            if(prevChar != '.' && prevChar != str[strIndex]) {
                wasAsteriskEncountered = false
            } else { // prevent skipping characters in the regExp pattern string
                --regExpIndex
            }
        }

        if(!wasAsteriskEncountered)
        {
            // evaluate if regExp character matches current string character
            if(topChar != '.' && topChar != str[strIndex]) {
                answer = false
                break
            }
        }

        ++regExpIndex
        ++strIndex

        if(regExpIndex >= regExp.length || strIndex >= str.length)
            break

        // push character from regExp
        if(!wasAsteriskEncountered) {
            regExpStack.push(regExp[regExpIndex])
        }
    }

    // last character comparison
    if(topChar == '.' && regExp.length < str.length)
        answer = false

    return answer
}