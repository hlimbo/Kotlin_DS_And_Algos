import java.lang.ArithmeticException

class dp50 {
    inner class Node(val num: Int? = null, val operator: Char? = null) {
        var leftNode: Node? = null
        var rightNode: Node? = null
    }

    inner class BinaryTree(val root: Node)

    fun preOrderEvaluation(node: Node?) : Int {
        if(node == null) {
            return 0
        }

        // base case
        if(node.num != null) {
            println("Integer number: ${node.num}")
            return node.num
        }

        println("Character operator: ${node.operator}")
        val num1: Int = preOrderEvaluation(node.leftNode)
        val num2: Int = preOrderEvaluation(node.rightNode)

        // kotlin says this is unreachable code....but it is reachable lol
        var intermediateSolution = when(node.operator) {
            '+' -> return num1 + num2
            '-' -> return num1 - num2
            '/' -> {
                try {
                    return num1 / num2
                } catch(e: ArithmeticException) {
                    throw ArithmeticException("preOrderEvaluation(): Cannot divide by zero!")
                }
            }
            '*' -> return num1 * num2
            else -> return 0
        }

        return intermediateSolution
    }
}

fun dailyProblem50(bt: dp50.BinaryTree) : Int {
    return dp50().preOrderEvaluation(bt.root)
}