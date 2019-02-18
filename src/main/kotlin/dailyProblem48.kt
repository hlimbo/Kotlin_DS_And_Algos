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
    return buildTree(preOrderList, inOrderList, 0, inOrderList.size - 1)
}

// From GeekForGeeks
/*
    1. Pick an element from Preorder, Increment a Preorder Index variable
    to pick next element in next recursive call
    2. Create a new tree node tNode with the data as picked element
    3. Find the picked element's index in Inorder. Let the index be inIndex
    4. Call buildTree for elements before inIndex and make the built tree as right subtree of tNode
    5. Call buildTree for elements after inIndex and make the build tree as right subtree of tNode
    6. return tNode
 */

// in a preorder traversal, the root node will always be the first element in the array
var pIndex = -1 // make this variable static and outside scope of buildTree because we want
// this variable to NOT have the same value when passing in the second call of buildTree function
// we want pIndex to update have global context!
fun buildTree(preOrderList: ArrayList<Char>, inOrderList: ArrayList<Char>, inStart: Int, inEnd: Int) : dp48.Node? {
    val dp = dp48()

    // base case
    if(inStart > inEnd || pIndex >= preOrderList.size)
        return null

    // 1
    pIndex += 1

    println("pIndex: $pIndex")

    // base case
    if(pIndex >= preOrderList.size)
        return null

    // 2
    val node = dp.Node(preOrderList[pIndex])

    // the other hidden base case one can forget about ~ how to identify if the current element in the array is a leaf node..
    if(inStart == inEnd)
        return node

    // 3 inOrder traversal, it is known that the middle element of the array is the root of the tree
    // val middleIndex: Int = (inEnd + 1 - inStart) / 2 // this is the middle index in a recursive element.. for all subtrees excluding root
    var middleIndex = -1
    for(m in 0 until inOrderList.size) {
        if(preOrderList[pIndex] == inOrderList[m]) {
            middleIndex = m
            break
        }
    }

    // 4 left half of inOrder array
    node.leftNode = buildTree(preOrderList, inOrderList, inStart, middleIndex - 1)

    // 5 right half of inOrder array
    node.rightNode = buildTree(preOrderList, inOrderList, middleIndex + 1, inEnd)

    // 6
    return node
}