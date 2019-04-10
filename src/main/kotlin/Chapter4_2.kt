import java.util.*

class Chapter4_2 {
    fun areBracketsBalanced(brackets: String): Boolean {

        val bracketMap = HashMap<Char, Char>()
        bracketMap['['] = ']'
        bracketMap['('] = ')'
        bracketMap['{'] = '}'
        val openingBrackets = "([{"
        val stack = Stack<Char>()

        for(bracket in brackets) {
            if(openingBrackets.contains(bracket)) {
                stack.push(bracket)
            } else {
                // if is a closing bracket
                if(stack.isEmpty())  {
                    return false
                }

                val complimentaryBracket = bracketMap[stack.peek()]
                if(complimentaryBracket == bracket) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}