import java.util.*
import kotlin.collections.HashMap

/*
This problem was asked by Facebook.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 */

fun DailyProblem27(str : String) : Boolean {
    val bracesStack = Stack<Char>()
    val bracesMap = HashMap<Char,Char>()
    bracesMap[')'] = '('
    bracesMap['}'] = '{'
    bracesMap[']'] = '['

    for(c in str) {

        // if not a valid bracket answer is evaluated to false (e.g. using letters abcdefg)
        if(!"({[]})".contains(c)) {
            return false
        }

        bracesStack.push(c)
        if(bracesStack.isNotEmpty()) {
            val brace : Char = bracesStack.peek()
            if(")}]".contains(brace)) {

                val closedBrace = bracesStack.pop()
                val expectedOpenBraceType : Char? = bracesMap[closedBrace]
                val openBrace = bracesStack.pop()

//                println("Closed brace: $closedBrace")
//                println("expected open brace type: $expectedOpenBraceType")
//                println("open brace: $openBrace")

                if(openBrace != expectedOpenBraceType) {
                    return false
                }
            }
        }
    }

    // an empty stack means that the string filled with brackets is balanced
    return bracesStack.isEmpty()
}