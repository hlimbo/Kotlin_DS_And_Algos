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

        println("preOrder traversal")
        preOrder(treeNode)
        println()
        println("inOrder traversal")
        inOrder(treeNode)
    }
})