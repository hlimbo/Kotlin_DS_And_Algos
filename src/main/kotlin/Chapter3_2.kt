
class Chapter3_2 {
    // assumption: value is a positive single digit (0 to 9 inclusive only)
    inner class Node(val value: Int,var next: Node?)

    fun transformToLongNumber(node: Node?): Long {
        var ptr: Node? = node
        val baseTen: Double = 10.0
        var i: Double = 0.0
        var sum: Long = 0
        while(ptr != null) {
            sum += Math.pow(baseTen, i).toLong() * ptr.value.toLong()
            i += 1
            ptr = ptr.next
        }

        return sum
    }

    fun convertLongNumberToLinkedList(num: Long) : Node? {
        if(num == 0L)
            return null

        val digit = (num % 10L).toInt()
        return Node(digit, convertLongNumberToLinkedList(num / 10L))
    }

    fun addTwoLinkedLists(node1: Node?, node2: Node?) : Node? {

        val n1: Long = transformToLongNumber(node1)
        val n2: Long = transformToLongNumber(node2)
        var sum: Long = n1 + n2

        // store each sum's digit in a linked list in reverse order
        return convertLongNumberToLinkedList(sum)
    }
}
