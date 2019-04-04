class Chapter3_3 {
    inner class Node(val data: Int, var next: Node?)
    fun swap2AdjacentNodes(rootNode: Node?, currentNode: Node?, prevNode: Node?): Node? {
        if(currentNode == null)
            return null

        // if we are at the end of the linked-list.... don't swap
        if(currentNode.next == null)
            return currentNode

        // if we are at the beginning of the linked list
        if(prevNode == null) {

            var temp: Node? = currentNode.next
            currentNode.next = currentNode.next!!.next
            var temp2 = currentNode
            temp?.next = currentNode

            return temp
        }

        // if we are somewhere in the middle of the linked list....
        // if(prevNode != null) {
        var prevNodeCopy: Node? = prevNode
        prevNodeCopy?.next = currentNode?.next

        var temp: Node? = currentNode.next
        temp?.next = currentNode

        var temp2: Node? = currentNode
        temp2?.next = currentNode.next?.next
        // }

        return rootNode
    }

}