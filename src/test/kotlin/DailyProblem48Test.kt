import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

// FAILED TO SOLVE
class DailyProblem48Test : FunSpec({

    fun preOrder(treeNode: dp48.Node?) {
        if(treeNode == null)
            return

        println(treeNode.letter)
        preOrder(treeNode.leftNode)
        preOrder(treeNode.rightNode)
    }

    fun inOrder(treeNode: dp48.Node?) {
        if(treeNode == null)
            return

        inOrder(treeNode.leftNode)
        println(treeNode.letter)
        inOrder(treeNode.rightNode)
    }

    test("First Test Case") {
        val preOrderList: ArrayList<Char> = arrayListOf('a', 'b', 'd', 'e', 'c' ,'f', 'g')
        val inOrderList: ArrayList<Char> = arrayListOf('d', 'b', 'e', 'a', 'f', 'c' , 'g')

        val treeNode: dp48.Node? = dailyProblem48(preOrderList, inOrderList)

        // to verify print out tree node in preOrder and inOrder orders and see if they are equal
        // to the original inputs order

//        val height = dp48().height(treeNode)
//        println("height: $height") // expecting a height of 2 but got 7...
//        println("preOrder traversal")
//        preOrder(treeNode)
//        println()
//        println("inOrder traversal")
//        inOrder(treeNode)
    }

    test("Simple Second Test Case") {
        val preOrderList: ArrayList<Char> = arrayListOf('a', 'b', 'd')
        val inOrderList: ArrayList<Char> = arrayListOf('b', 'a', 'd')

        val treeNode: dp48.Node? = dailyProblem48(preOrderList, inOrderList)
        val height = dp48().height(treeNode)
        println("height: $height")
        println("preOrder:")
        preOrder(treeNode)
        println("inOrder:")
        inOrder(treeNode)
    }

    test("Simpler Third Test Case") {
        val preOrderList: ArrayList<Char> = arrayListOf('a', 'b')
        val inOrderList: ArrayList<Char> = arrayListOf('b', 'a')

        val treeNode: dp48.Node? = dailyProblem48(preOrderList, inOrderList)
        val actualDepth = dp48().height(treeNode)
        val count = dp48().nodeCount(treeNode)
        println("height: $actualDepth")
        println("node count: $count")
        println("preOrder:")
        preOrder(treeNode)
        println("inOrder:")
        inOrder(treeNode)
    }
})