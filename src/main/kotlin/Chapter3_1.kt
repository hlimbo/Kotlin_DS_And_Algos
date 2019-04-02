import java.util.*

class Chapter3_1 {
    inner class Node(val data: Int, var next: Node?)

    // Time Complexity O(n) | Space Complexity O(n)
    fun reversedLinkedList(root: Node?): Node? {
        val nodeStack = Stack<Node?>()
        var ptr: Node? = root
        while(ptr != null) {
            nodeStack.push(ptr)
            ptr = ptr.next
        }

        val answer: Node? = if(nodeStack.isNotEmpty()) nodeStack.peek() else null
        while(nodeStack.isNotEmpty()) {
            val node: Node? = nodeStack.pop()
            if(nodeStack.isNotEmpty()) {
                val node2: Node? = nodeStack.peek()
                node?.next = node2
            } else {
                node?.next = null
            }
        }

        return answer
    }
}