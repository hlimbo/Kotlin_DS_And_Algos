import kotlin.math.log

// come back to this tomorrow......
class Node (val letter: Char) {
    init {
        println(letter)
    }

    var leftNode: Node? = null
    var rightNode: Node? = null
}

class BinaryTree(val root: Node) {
    init {
        println("Binary Tree")
        println(root.letter)
    }
}

fun preOrderTree(arr: ArrayList<Char>) : BinaryTree {

    val rootCharacter: Char = arr[0]
    val tree = BinaryTree(Node(rootCharacter))

    // derived from max number of nodes formula: n = (2^k) - 1
    // where n = max number of nodes in a full binary tree (full means all leaf nodes share the same level as the depth)
    // and k = the depth of the tree (depth = max level obtained from a leaf node)
    val n: Float = arr.size.toFloat()
    val depth = log(n + 1.0, 2.0)


    tree.root.leftNode = Node(arr[1])
    // tree.root.leftNode.leftNode = Node(arr[2])


    // try something iteratively instead....
    for(i in 1 until arr.size) {

    }

    return BinaryTree(Node('R'))
}