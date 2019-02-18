import kotlin.math.log

// FAILED TO SOLVE :(


class dp48 {
    inner class Node(val letter: Char) {
        var leftNode: Node? = null
        var rightNode: Node? = null
    }

    fun height(node: Node?) : Int {
        // base case
        if(node == null)
            return 0

        val leftTreeDepth = 1 + height(node.leftNode)
        val rightTreeDepth = 1 + height(node.rightNode)

        return Math.max(leftTreeDepth, rightTreeDepth)
    }

    fun nodeCount(node: Node?) : Int {
        if(node == null)
            return 0

        val leftCount = 1 + nodeCount(node.leftNode)
        val rightCount = 1 + nodeCount(node.rightNode)

        return leftCount + rightCount
    }
}
// assumption: preOrderList contains an identical set of characters in inOrderList
// otherwise the problem will become impossible to solve..
fun dailyProblem48(preOrderList: ArrayList<Char>, inOrderList: ArrayList<Char>) : dp48.Node? {
    // in a preOrder traversal the root node will always be the first element in an array representation
    val preOrderIndex = 0
    // in an inOrder traversal, the root node will always be the middle element in an array representation
    val inOrderIndex = inOrderList.size / 2
    return buildTree(preOrderList, preOrderIndex, inOrderList, inOrderIndex)
}

// From GeekForGeeks
/*
    1. Pick an element from Preorder, Increment a Preorder Index variable
    to pick next element in next recursive call
    2. Create a new tree node tNode with the data as picked element
    3. Find the picked element's index in Inorder. Let the index be inIndex
    4. Call buildTree for elements before inIndex and make the built tree as right subtree of tNode
    5. return tNode
 */

fun buildTree(preOrderList: ArrayList<Char>, preOrderIndex: Int, inOrderList: ArrayList<Char>, inOrderIndex: Int) : dp48.Node? {
    val dp = dp48()

    // base case ~ looks like I may have an incorrect base case
    if(preOrderIndex == preOrderList.size || preOrderIndex < 0)
        return null

    // 1
    var pIndex = preOrderIndex
    pIndex++

    // 2
    val node = dp.Node(preOrderList[preOrderIndex])


    // 4
    node.leftNode = buildTree(preOrderList, pIndex, inOrderList, (inOrderIndex / 2) - 1)

    // 5
    node.rightNode = buildTree(preOrderList, (inOrderIndex / 2) - 1, inOrderList, pIndex)

    // 6
    return node
}