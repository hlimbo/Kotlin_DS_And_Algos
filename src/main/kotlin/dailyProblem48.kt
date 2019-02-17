import kotlin.math.log

// FAILED TO SOLVE :(


class dp48 {
    inner class Node(val letter: Char) {
        var parent: Node? = null
    }
}
// assumption: preOrderList contains an identical set of characters in inOrderList
// otherwise the problem will become impossible to solve..
fun dailyProblem48(preOrderList: ArrayList<Char>, inOrderList: ArrayList<Char>) : dp48.Node {

    // base case: Both arrays have size of 1
    if(preOrderList.size == 1) {
        val c: Char = preOrderList[0]
        println("Base Case: Character used: $c")
        return dp48().Node(c)
    }

    preOrderList.removeAt(0)
    dailyProblem48(preOrderList, inOrderList)

    return dp48().Node('R')
}

//fun helper(preOrderList: ArrayList<Char>): dp48.Node {
//    val rootChar: Char = preOrderList.removeAt(0)
//    val root = dp48().Node(rootChar)
//    return bottomUp(preOrderList, root)
//}
//
//// modify root by implicitly adding in child nodes to it
//fun bottomUp(preOrderList: ArrayList<Char>, root: dp48.Node?) {
//
//    val dp = dp48()
//    // base case
//    if(preOrderList.size == 1) {
//        val n = dp.Node(preOrderList[0])
//        n.parent = root
//        return n
//    }
//
//    val c: Char = preOrderList.removeAt(0)
//    val node = dp.Node(c)
//    node.parent = root
//    bottomUp(preOrderList, node)
//    bottomUp(preOrderList, node)
//
//    return dp48().Node('R')
//}